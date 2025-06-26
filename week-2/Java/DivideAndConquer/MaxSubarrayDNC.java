class MaxSubarrayDNC {

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(arr, 0, arr.length - 1)); // Output: 6
    }

    static int maxSubArray(int[] arr, int left, int right) {
        if (left == right)
            return arr[left]; // base case: 1 element

        int mid = (left + right) / 2;

        int leftMax = maxSubArray(arr, left, mid);
        int rightMax = maxSubArray(arr, mid + 1, right);
        int crossMax = maxCrossingSum(arr, left, mid, right);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    static int maxCrossingSum(int[] arr, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;

        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }
}
