class ParkingSystem {
    private int[] lot;

    public ParkingSystem(int big, int medium, int small) {
        lot = new int[4];
        lot[1] = big;
        lot[2] = medium;
        lot[3] = small;
    }
    
    public boolean addCar(int carType) {
        lot[carType]--;
        return lot[carType] >= 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
