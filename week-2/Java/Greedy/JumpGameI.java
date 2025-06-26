
public class JumpGameI {
    /*
     * Given an array of integers `arr`, each element in the array represents the
     * maximum jump length at that position. Initially starting at the first index
     * of the array, determine if it is possible to reach the last index. Return
     * true if the last index can be reached, otherwise return false.
     */
    public static void main(String[] args) {
        int[] input = { 2, 3, 1 };

        System.out.println(canJump(input));
    }

    public static boolean canJump(int[] arr) {
        int maxJump = 0;

        for (int i = 0; i < arr.length; i++) {
            if (maxJump >= arr.length - 1)
                return true;
            if (i > maxJump)
                // unreachable
                return false;
            maxJump = Math.max(maxJump, arr[i] + i);
        }
        return true;

    }
}
