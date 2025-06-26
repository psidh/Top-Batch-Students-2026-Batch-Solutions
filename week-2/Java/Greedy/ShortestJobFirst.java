import java.util.Arrays;

 class ShortestJobFirst {
    /*
     * Given an array of n integers representing the burst times of processes,
     * determine the average waiting time for all processes and return the closest
     * whole number that is less than or equal to the result.
     */
    public static void main(String[] args) {
        int[] input = { 4, 1, 3, 7, 2 };
        System.out.println(solve(input));
    }

    public static long solve(int[] bt) {
        long sum = 0;
        long acc = 0;
        Arrays.sort(bt);
        for (int i : bt) {
            sum += acc;
            acc += i;
        }
        return (long) Math.floor(sum / bt.length);
    }
}
