
import java.util.Scanner;

public class SearchInRotatedSorted {
    public static void main(String[] args) {
        int[][] sorted = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int target = sc.nextInt();
        int flag = 0;
        sc.close();

        for (int i = 0; i < 3; i++) {
            int a = 0;
            int b = sorted[i].length;

            while (a <= b) {
                int mid = (a + b) / 2;

                if (sorted[i][mid] == target) {
                    flag = 1;
                    System.out.println("Found");
                    return;
                } else if (sorted[i][mid] < target) {
                    a = mid + 1;
                } else {
                    b = mid - 1;
                }
            }
        }

        sc.close();
        if (flag == 0)
            System.out.println("Not Exist");
    }
}
