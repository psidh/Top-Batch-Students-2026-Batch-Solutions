
public class MatrixAdd {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] arr2 = { { 1, 1, 1 }, { 1, 1, 6 } };
        int[][] arr3 = new int[3][3];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                arr3[i][j] = arr[i][j] + arr2[i][j];
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("arr[" + i + "]" + "[" + j + "]" + " : " + arr3[i][j]);
            }
            System.out.println();
        }
    }

}
