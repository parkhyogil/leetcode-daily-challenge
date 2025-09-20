import java.util.*;

class Router {
    class Packet {
        int source, destination, timestamp;

        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Packet packet = (Packet) o;
            return source == packet.source && destination == packet.destination && timestamp == packet.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }

    private int limit;
    private Queue<Packet> queue;
    private Set<Packet> set;
    private Map<Integer, List<Packet>> packetMap;

    public Router(int memoryLimit) {
        limit = memoryLimit;
        queue = new ArrayDeque<>();
        set = new HashSet<>();
        packetMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        if (set.contains(packet)) {
            return false;
        }

        if (queue.size() == limit) {
            forwardPacket();
        }

        queue.offer(packet);
        set.add(packet);

        packetMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(packet);
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) {
            return new int[0];
        }
        Packet packet = queue.poll();
        set.remove(packet);

        packetMap.get(packet.destination).remove(packet);
        return new int[] {packet.source, packet.destination, packet.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!packetMap.containsKey(destination)) {
            return 0;
        }
        List<Packet> packets = packetMap.get(destination);

        return binarySearch(packets, endTime + 1) - binarySearch(packets, startTime);
    }
    
    private int binarySearch(List<Packet> list, int target) {
        int hi = list.size() - 1;
        int lo = Math.max(0, hi + 1 - limit);

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (list.get(mid).timestamp < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return lo;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
