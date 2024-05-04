# [721. Accounts merge](https://leetcode.com/problems/accounts-merge/description/)

## Intuition
Disjoint Set을 이용해 서로 공통된 메일을 가지고 있는 계정끼리 그룹화한다.

## Algorithm
1. DisjointSet `ds`를 `accounts`의 사이즈로 초기화한다.
2. `accounts`를 순회하여 모든 메일에 대해 메일을 key로 계정의 id를 값으로 `accountID`에 저장한다. 이미 저장되어 있는 메일일 경우 다른 계정에 속해있는 메일이기 때문에 두 계정을 그룹화한다.
3. 그룹화를 끝낸 후 모든 메일들을 `mailLists`에 계정ID 별로 저장한다.
4. 모든 계정ID를 순회하여 계정의 이름과 계정의 메일 목록을 정렬하여 `res`에 저장하고 리턴한다.

## Implementation
```java
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        DisjointSet ds = new DisjointSet(n);

        Map<String, Integer> accountID = new HashMap<>();

        for (int id = 0; id < n; id++) {
            List<String> account = accounts.get(id);

            for (int j = 1; j < account.size(); j++) {
                String mail = account.get(j);

                if (!accountID.containsKey(mail)) {
                    accountID.put(mail, id);
                } else {
                    ds.union(id, accountID.get(mail));
                }
            }
        }

        Map<Integer, List<String>> mailLists = new HashMap<>();
        for (String mail : accountID.keySet()) {
            int group = ds.findRoot(accountID.get(mail));

            mailLists.computeIfAbsent(group, key -> new ArrayList<>()).add(mail);
        }

        List<List<String>> res = new ArrayList<>();
        for (Integer id : mailLists.keySet()) {
            List<String> merged = new ArrayList<>();

            String name = accounts.get(id).get(0);
            List<String> mailList = mailLists.get(id);


            merged.add(name);
            Collections.sort(mailList);
            merged.addAll(mailList);

            res.add(merged);
        }

        return res;
    }

    class DisjointSet {
        private int size;
        private int[] root;

        public DisjointSet(int size) {
            this.size = size;
            root = new int[size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }

        public void union(int a, int b) {
            a = findRoot(a);
            b = findRoot(b);

            if (a < b) {
                root[b] = a;
            } else {
                root[a] = b;
            }
        }

        public int findRoot(int child) {
            if (child == root[child]) {
                return child;
            }
            return root[child] = findRoot(root[child]);
        }
    }
}
```

## Complexity
`N`은 `accounts`의 사이즈, `M`은 `account`가 가질 수 있는 최대 길이. 
- Time complexity: O(NMlogNM)\
DisjointSet으로 그룹화에 사용한 시간은 거의 상수 시간을 사용하므로 O(NM)의 시간을 사용.\
최악의 케이스일 경우 모든 메일이 하나의 그룹으로 모여있다면 정렬에 사용된 시간은 O(NMlogNM)이 된다.

- Space complexity: O(NM)\
`ds`에서 `N`의 공간을 사용. `accountID`와 `mailLists`에서 메일의 개수인 NM의 공간을 사용.