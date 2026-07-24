class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] times = new double[target];
        for (int i = 0; i < position.length; i++) {
            int pos = position[i];
            double time = (double) (target - pos) / speed[i];
            times[pos] = time;
        }
        double fleetTime = times[times.length - 1];
        int fleets = fleetTime == 0d ? 0 : 1;
        for (int i = times.length - 2; i >= 0; i--) {
            if (times[i] > fleetTime) {
                fleetTime = times[i];
                fleets++;
            }
        }
        return fleets;
    }
}
