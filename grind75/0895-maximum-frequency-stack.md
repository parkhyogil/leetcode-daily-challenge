# [895. Maximum Frequency Stack](https://leetcode.com/problems/maximum-frequency-stack/description/)

## Intuition
이 문제에서 고려해야할 점은 삽입되는 요소의 빈도와 입력되는 순서이다.
요소별로 빈도를 관리하고, 빈도마다 입력된 순서를 스택으로 관리한다.


예를 들어, 아래와 같은 입력이 주어졌을 때
```
["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
```
각각의 요소의 빈도와 그 빈도를 기준으로 스택으로 관리하는 과정은 아래와 같다.
```
element  ->  frequency    |    frequency  ->  stack
5            1            |    1              {5}
----------------------------------------------------
5            1            |    1              {5,7}
7            1            |
----------------------------------------------------
5            2            |    1              {5,7}
7            1            |    2              {5}
----------------------------------------------------
5            2            |    1              {5,7}
7            2            |    2              {5,7}
----------------------------------------------------
5            2            |    1              {5,7,4}
7            2            |    2              {5,7}
4            1            |    
----------------------------------------------------
5            3            |    1              {5,7,4}
7            2            |    2              {5,7}
4            1            |    3              {5}
----------------------------------------------------
5            2            |    1              {5,7,4}
7            2            |    2              {5,7}
4            1            |
----------------------------------------------------
5            2            |    1              {5,7,4}
7            1            |    2              {5}
4            1            |   
----------------------------------------------------
5            1            |    1              {5,7,4}
7            1            |    
4            1            |   
----------------------------------------------------
5            1            |    1              {5,7}
7            1            |   
```
`push` 메소드는 삽입되는 요소의 빈도를 증가시키고, 현재 요소의 빈도가 최대 빈도보다 크다면 최대 빈도도 증가시킨다. 그리고 요소의 빈도에 매핑된 스택에 요소를 삽입한다.\
`pop` 메소드는 현재 최고 빈도와 매핑된 스택에서 마지막에 삽입된 요소를 제거한다. 
그리고 제거된 요소의 빈도를 감소시켜 그 요소가 마지막으로 저장된 스택을 가리키게 한다.

두 개의 `HashMap`과 빈도 마다 `Stack`을 사용해 문제를 해결할 수 있다.
 

## Implementation
```java
class FreqStack {
    private int maxFrequency;
    private Map<Integer, Integer> elementFrequencyMap;
    private Map<Integer, Stack<Integer>> frequencyStackMap;

    public FreqStack() {
        maxFrequency = 0;
        elementFrequencyMap = new HashMap<>();
        frequencyStackMap = new HashMap<>();
    }
    
    public void push(int val) {
        elementFrequencyMap.put(val, elementFrequencyMap.getOrDefault(val, 0) + 1);
        int frequency = elementFrequencyMap.get(val);

        if (frequency > maxFrequency) {
            maxFrequency++;
        }
        
        frequencyStackMap.computeIfAbsent(frequency, k -> new Stack<>()).push(val);
    }
    
    public int pop() {
        int value = frequencyStackMap.get(maxFrequency).pop();

        elementFrequencyMap.put(value, elementFrequencyMap.get(value) - 1);

        if (frequencyStackMap.get(maxFrequency).isEmpty()) {
            maxFrequency--;
        }

        return value;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
```

## Complexity
`n`은 삽입되는 요소의 개수
- Time complexity:
  - `push` : O(1)
  - `pop` : O(1)
- Space complexity: O(n)
