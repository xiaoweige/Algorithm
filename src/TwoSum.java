import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer> ( );
        for (int i = 0; i < nums.length; i++) {
            map.put (nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey (complement) && map.get (complement) != i) {
                return new int[]{i, map.get (complement)};
            }
        }
        throw new IllegalArgumentException ("No tow sum solution");
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum ( );
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.twoSum (nums, target);
        System.out.println (result[0] + "" + result[1]);
    }
}
