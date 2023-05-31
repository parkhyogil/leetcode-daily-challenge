class UndergroundSystem {
    
    Map<Integer, Passenger> passengers;
    Map<String, RouteInfo> routes;

    public UndergroundSystem() {
        passengers = new HashMap<>();
        routes = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Passenger p = new Passenger(id);
        p.checkIn(stationName, t);
        passengers.put(id, p);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Passenger p = passengers.get(id);
        p.checkOut(stationName, t);
        
        String route = p.getRoute();
        if (!routes.containsKey(route)) {
            routes.put(route, new RouteInfo(route));
        }
        routes.get(route).addPassenger(p);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return routes.get(startStation + "-" + endStation).getAverageTime();
    }
    
    class Passenger {
        int id;
        String checkInStation;
        String checkOutStation;
        int checkInTime;
        int checkOutTime;
        
        Passenger(int id) {
            this.id = id;
        }
        
        void checkIn(String checkInStation, int checkInTime) {
            this.checkInStation = checkInStation;
            this.checkInTime = checkInTime;
        }
        
        void checkOut(String checkOutStation, int checkOutTime) {
            this.checkOutStation = checkOutStation;
            this.checkOutTime = checkOutTime;
        }
        
        String getRoute() {
            return checkInStation + "-" + checkOutStation;
        }
        
        int getTime() {
            return checkOutTime - checkInTime;
        }
    }
    
    class RouteInfo {
        String route;
        int passengerCount;
        int totalTime;
        
        RouteInfo(String route) {
            this.route = route;
            passengerCount = 0;
            totalTime = 0;
        }
        
        void addPassenger(Passenger p) {
            passengerCount++;
            totalTime += p.getTime();
        }
        
        double getAverageTime() {
            return (double) totalTime / passengerCount;
        }
    }
}
