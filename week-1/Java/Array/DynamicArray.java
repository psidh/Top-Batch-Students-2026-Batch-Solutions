
import java.util.Scanner;

public class DynamicArray {
    public static void main(String[] args) {
        int[] start = { 1, 2, 3 };

        Scanner sc = new Scanner(System.in);
        String ch = "";
        int[] newArray;
        while (!ch.equals("n")) {
            ch = sc.nextLine();

            if (ch.equals("y")) {
                newArray = new int[start.length * 2 + 1];
                for (int i = 0; i < start.length; i++) {
                    newArray[i] = start[i];
                }
                start = newArray;
                System.out.println("Array resized to length: " + start.length);
            }
        }

        sc.close();
    }
}
