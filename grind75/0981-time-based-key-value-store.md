# [981. Time Based Key-Value Store](https://leetcode.com/problems/time-based-key-value-store/)

## Intuition
`timestamp`가 오름차순으로 관리가 되니 선형탐색이 아닌 이진탐색으로 검색 시간을 줄일 수 있다.

## Algorithm
`key`를 key로 하고 `timestamp-value`를 쌍으로 관리하는 List를 value로 하는 Map `map`을 선언.\
- set:
  1. `map`에 `key`가 없을 경우 새 리스트를 저장하고 이진탐색을 편하게 하기 위해 `0-""`를 리스트에 저장한다.
  2. 리스트에 `timestamp-value` 쌍을 저장한다.
- get:
  1. `map`에 `key`가 없다면 `""`를 리턴.
  2. `list`에 `map`에 저장된 리스트를 할당.
  3. `lo`에 0, `hi`에 `list`의 마지막 인데스 할당.
  4. `lo`가 `hi`보다 작거나 같다면 아래를 반복하여 `list`의 왼쪽 구간은 `timestamp`보다 작거나 같은 값, 오른쪽 구간은 큰 값으로 나눌 수 있다.
     1. `mid`에 `lo`와 `hi`의 중점을 할당.
     2. `list`의 `mid`번째 값이 `timestamp`보다 작거나 같으면 `lo`를 `mid + 1`로 증가.
     3. 그게 아니라면 `hi`를 `mid - 1`로 감소.
  5. `hi`가 `timestamp`보다 작거나 같은 값의 끝 부분을, `lo`가 `timestamp`보다 큰 값의 시작 부분을 가리키게 되니 `list`의 `hi`번째 값을 리턴.



## Implementation
```java
class TimeMap {
    private Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
            map.get(key).add(new Pair(0, ""));
        }
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair<Integer, String>> list = map.get(key);
        int lo = 0;
        int hi = list.size() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (list.get(mid).getKey() <= timestamp) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return list.get(hi).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
```

## Complexity
`n`은 저장된 `value`의 개수.
- Time complexity:
  - set: O(1)
  - get: O(logn)
- Space complexity: O(n)
