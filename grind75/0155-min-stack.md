# [155. Min Stack](https://leetcode.com/problems/min-stack/)

## Intuition
두개의 스택으로 하나는 값, 하나는 최소값을 저장해 만든다.

## Algorithm
- push: `values`에 삽입, 새 값이 `minValues`의 탑보다 작거나 같으면 삽입. 
- pop: `values`의 탑이 `minValues`의 탑과 같다면 둘 다 삭제, 아니면 `values`만 삭제. 
- top: `values`의 탑을 리턴. 
- getMin: `minValues`의 탑을 리턴.

## Implementation
```java
class MinStack {
    private Stack<Integer> values;
    private Stack<Integer> minValues;

    public MinStack() {
        values = new Stack<>();
        minValues = new Stack<>();
    }
    
    public void push(int val) {
        values.push(val);
        if (minValues.isEmpty() || val <= minValues.peek()) {
            minValues.push(val);
        }
    }
    
    public void pop() {
        if (Integer.compare(values.peek(), minValues.peek()) == 0) {
            minValues.pop();
        }
        values.pop();
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return minValues.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

## Complexity
- Time complexity: 
  - push: O(1)
  - pop: O(1)
  - top: O(1)
  - getMin: O(1)

- Space complexity: O(n)\
`n`은 삽입된 값.
