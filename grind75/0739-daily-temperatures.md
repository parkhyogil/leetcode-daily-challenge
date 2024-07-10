# [739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures/description/)

## Intuition
처리 대기 중인 인덱스들을 최근에 들어온 순서대로 현재 위치한 인덱스와 비교하여, 현재 온도보다 낮은 인덱스들을 처리한다. 
만약 온도가 낮은 인덱스가 없다면 현재 인덱스를 처리 대기 중인 인덱스에 추가한다. 
이렇게 하면 처리 대기 중인 인덱스들의 온도는 내림차순으로 관리되며, 다음 인덱스로 넘어가서 비교할 때 다음 인덱스의 온도가 최근에 들어온 처리 대기 중인 온도보다 낮다면 나머지 인덱스들과 비교할 필요가 없어진다. 
이 과정은 스택 자료구조를 이용해 쉽게 구현할 수 있다.

## Algorithm
1. 변수를 초기화한다.
   - `n` : 배열 `temperatures`의 길이
   - `stack` : 인덱스를 저장할 스택.
   - `res` : 결과를 저장한 배열.
2. 배열 `temperatures`를 순회한다.
   1. `stack`이 비어있지 않고 현재 인덱스의 온도가 스택의 마지막 인덱스의 온도보다 높다면 아래를 반복한다.
      1. `stack`에서 꺼낸 인덱스를 `j`에 저장한다.
      2.  `i`는 `j`보다 따듯한 첫 번째 인덱스가 된다. `res[j]`에 두 인덱스의 차이를 저장한다.
   2. 현재 인덱스를 `stack`에 삽입한다.
3. `stack`에 남아있는 인덱스는 더 따듯한 날을 찾지 못한 인덱스이다. `res`에 기본값인 0이 들어있다.
4. `res`를 리턴한다.

## Implementation
```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        Stack<Integer> stack = new Stack<>();

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();

                res[j] = i - j;
            }
            stack.push(i);
        }

        return res;
    }
}
```

## Complexity
`n`은 `temperatures`의 길이.
- Time complexity: O(n)\
`temperatures`를 한 번 순회한다.
 
- Space complexity: O(n)\
`stack`에 최대 `n`개의 데이터가 삽입될 수 있다.
