# [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/)

## Intuition
최소한의 시간으로 모든 작업을 완료하기 위해 빈도가 높은 작업부터 처리해야한다. 우선순위 큐 자료구조를 사용해 빈도가 높은 작업부터 처리할 수 있다.\
한 사이클에서 최대 `n + 1`개의 작업을 처리할 수 있다. 빈도가 높은 작업을 처리한 뒤 `n`의 쿨링 타임 동안 다른 `n`개의 작업을 처리하면 된다. 

## Algorithm
1. 변수를 초기화한다.
   - `pq` : 작업의 빈도를 내림차순으로 정렬한 우선순위 큐.
   - `freq` : 작업의 빈도를 저장한 배열.
   - `res` : 모든 작업을 완료하기 위해 필요한 최소 시간.
2. `tasks` 배열을 순회해 작업별 빈도를 `freq`에 저장한다.
3. `freq` 배열을 순회해 빈도가 0보다 큰 작업을 `pq`에 삽입한다.
4. 모든 작업을 완료할 때까지 아래를 반복한다.
   1. 남은 작업의 최대 빈도가 1이고 작업 수가 `n + 1`보다 작거나 같다면 마지막 사이클이다. `res`에 남은 작업 수를 더하고 반복문을 종료한다.
   2. 작업의 중복 처리를 막기 위한 리스트 `next`를 초기화한다.
   3. `pq`에서 `n + 1`개의 작업을 꺼내 빈도를 1 감소시키고 처리 횟수가 남은 작업은 `next`에 저장한다. 
   4. `next`에 남은 작업을 `pq`에 모두 삽입한다.
   5. `res`에 `n + 1` 시간을 더한다.
5. `res`를 리턴한다.

## Implementation
```java
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] freq = new int[26];
        int res = 0;

        for (char task : tasks) {
           freq[task - 'A']++;
        }

        for (int num : freq) {
            if (num > 0) {
                pq.offer(num);
            }
        }

        while (!pq.isEmpty()) {
            if (pq.peek() == 1 && pq.size() <= n + 1) {
                res += pq.size();
                break;
            }

            List<Integer> next = new ArrayList<>();

            for (int i = 0; i <= n && !pq.isEmpty(); i++) {
                int num = pq.poll();

                if (num > 1) {
                    next.add(num - 1);
                }
            }

            pq.addAll(next);

            res += n + 1;
        }

        return res;
    }
}
```

## Complexity
`n`은 배열 `tasks`의 길이. `k`는 작업의 종류
- Time complexity: O(n log k) => O(n)\
우선순위 큐 `pq`의 삽입, 삭제 연산은 `O(log k)` 시간이 걸린다. 여기서 `k`는 최대가 26인 고정된 값이므로, 최종 시간 복잡도는 `O(n)`으로 표현할 수 있다.
  
- Space complexity: O(k) => O(1)\
작업의 종류는 최대 26개다. 배열 `freq`의 길이와 우선순위 큐 `pq`의 사이즈는 최대 26이 된다.