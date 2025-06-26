import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permutation(nums));
    }

    private static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];

        function(0, nums, list, vis, new ArrayList<>());
        return list;
    }

    private static void function(int index, int[] nums, List<List<Integer>> list, boolean[] vis,
            List<Integer> ds) {

        if (ds.size() >= nums.length) {
            list.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                ds.add(nums[i]);
                function(i + 1, nums, list, vis, ds);
                ds.remove(ds.size() - 1);
                vis[i] = false;
            }
        }
        return;
    }

}
