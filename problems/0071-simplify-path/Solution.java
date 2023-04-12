class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        int idx = 0;

        for (String s : strs) {
            if (s.isEmpty()) {
                continue;
            } else if (s.equals("..")) {
                idx = Math.max(0, idx - 1);
            } else if (!s.equals(".")) {
                strs[idx++] = s;
            }
        }

        if (idx == 0) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            sb.append('/').append(strs[i]);
        }
        return sb.toString();
    }
}
