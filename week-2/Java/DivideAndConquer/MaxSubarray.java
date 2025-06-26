
public class MaxSubarray {
    public static void main(String[] args) {
        int[] arr = {-1, -4, 5, 6, -9};

        int maxSum = arr[0];
        int currSum = arr[0];

        for(int i = 1 ; i < arr.length; i++){
            currSum = Math.max(arr[i], arr[i] + currSum);
            maxSum = Math.max(maxSum, currSum);
        }
        System.out.println(maxSum);
    }
}
