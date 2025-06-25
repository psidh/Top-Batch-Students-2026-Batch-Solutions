
public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 } };

        int[][] arr2 = new int[3][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                arr2[j][i] = arr[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
