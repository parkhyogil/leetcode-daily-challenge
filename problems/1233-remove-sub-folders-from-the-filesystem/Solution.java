class Solution {
    class Folder {
        String name;
        boolean isEnd;
        Map<String, Folder> subFolders;

        Folder(String name) {
            this.name = name;
            subFolders = new HashMap<>();
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        Folder root = new Folder("/");

        for (String s : folder) {
            Folder f = root;
            int j = 1;

            for (int i = 2; i <= s.length() && !f.isEnd; i++) {
                if (i == s.length() || s.charAt(i) == '/') {
                    String subName = s.substring(j, i);

                    f = f.subFolders.computeIfAbsent(subName, k -> new Folder(subName));

                    j = i + 1;
                }
            }

            f.isEnd = true;
        }

        List<String> result = new ArrayList<>();

        for (Folder sub : root.subFolders.values()) {
            result.addAll(printSubFolders(sub));
        }

        return result;
    }

    List<String> printSubFolders(Folder folder) {
        List<String> result = new ArrayList<>();

        char[] chars = new char[101];
        chars[0] = '/';

        dfs(1, folder, chars, result);

        return result;
    }

    void dfs(int i, Folder folder, char[] chars, List<String> result) {
        for (char c : folder.name.toCharArray()) {
            chars[i++] = c;
        }

        if (folder.isEnd) {
            result.add(String.valueOf(chars, 0, i));
            return;
        }

        chars[i++] = '/';

        for (Folder sub : folder.subFolders.values()) {
            dfs(i, sub, chars, result);
        }
    }
}
