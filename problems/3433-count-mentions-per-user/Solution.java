class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int n = numberOfUsers;

        events.sort((a, b) -> {
            int d = Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1));

            if (d == 0) {
                return a.get(0).equals("OFFLINE") ? -1 : 1;
            }
            return d;
        });

        int[] result = new int[n];
        int[] onlineTime = new int[n];

        for (List<String> e : events) {
            int t = Integer.parseInt(e.get(1));
            String m = e.get(2);

            if (e.get(0).equals("MESSAGE")) {
                if (m.equals("ALL")) {
                    for (int i = 0; i < n; i++) {
                        result[i]++;
                    }
                } else if (m.equals("HERE")) {
                    for (int i = 0; i < n; i++) {
                        if (onlineTime[i] <= t) {
                            result[i]++;
                        }
                    }
                } else {
                    for (String id : e.get(2).split(" ")) {
                        result[Integer.parseInt(id.substring(2))]++;
                    }
                }
            } else {
                int id = Integer.parseInt(e.get(2));
                onlineTime[id] = t + 60;
            }
        }


        return result;
    }
}
