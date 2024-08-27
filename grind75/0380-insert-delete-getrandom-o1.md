# [380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/description/)

## Intuition
리스트의 마지막 값을 삭제하는데 `O(1)`의 시간 복잡도가 사용되는 점을 활용한다.\
값을 리스트에 저장하고, 값의 인덱스를 해시맵으로 관리한다. 값을 삭제할 때 삭제할 값의 인덱스에 리스트의 마지막 값을 넣고 리스트의 마지막 값을 삭제한다. 그리고 해시맵에서 변경된 인덱스를 업데이트한다.

## Algorithm
- 필드 
  - `int lastIndex` : 리스트의 마지막 인덱스
  - `List<Integer>` : 값을 저장한 리스트
  - `Map<Integer, Integer> indexMap` : 리스트에 저장된 값의 인덱스 맵
  - `Random random` : 랜덤한 인덱스를 얻기 위한 랜덤 객체
- 생성자 
  - `lastIndex`를 `-1`로 초기화한다.
  - `values`, `indexMap`, `random`을 초기화한다.
- 메소드
  - `insert` 
    1. 추가할 값이 이미 존재한다면 `false`를 반환한다.
    2. `lastIndex`를 1 증가시키고 `values`에 값을 추가한다.
    3. `indexMap`에 현재 값을 키로, 인덱스를 값으로 추가한다.
    4. `true`를 반환한다.
  - `remove`
    1. 제거할 값이 존재하지 않으면 `false`를 반환한다.
    2. `indexMap`에서 값을 제거하고 해당 인덱스를 `deletedIndex`에 할당한다.
    3. `values`의 마지막 값을 제거하고 `lastValue`에 할당한다.
    4. `deletedIndex`가 `values`의 크기보다 작다면, `values`의 `deletedIndex`의 값을 `lastValue`로 변경하고, `indexMap`에서 `lastValue`의 인덱스를 `deletedIndex`로 변경한다. 
  - `getRandom`
    1. `0 ~ lastIndex` 사이의 랜덤한 값을 인덱스로 사용해 `values`에서 해당 인덱스의 값을 반환한다.

## Implementation
```java
class RandomizedSet {
    private int lastIndex;
    private List<Integer> values;
    private Map<Integer, Integer> indexMap;
    private Random random;

    public RandomizedSet() {
        lastIndex = -1;
        values = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }   

        lastIndex++;
        values.add(val);
        indexMap.put(val, lastIndex);

        return true;
    }
    
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        
        int deletedIndex = indexMap.remove(val);
        int lastValue = values.remove(lastIndex--);

        if (deletedIndex < values.size()) {
            values.set(deletedIndex, lastValue);
            indexMap.replace(lastValue, deletedIndex);
        }

        return true;
    }
    
    public int getRandom() {
        return values.get(random.nextInt(lastIndex + 1));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
```

## Complexity
- Time complexity:
  - `insert` : O(1)
  - `remove` : O(1)
  - `getRandom` : O(1)
