
public class TowerHanoi {

    public static void main(String[] args) {
        solve(3, 'A', 'B', 'C');

    }

    public static void solve(int n, char src, char helper, char dest) {
        if (n == 1) {
            System.out.println("Transferring from " + src + " to " + dest);
            return;
        }

        solve(n - 1, src, dest, helper);
        System.out.println("Transferring from " + src + " to " + dest);
        solve(n - 1, helper, src, dest);
    }
}