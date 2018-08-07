import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/10
 * Time: 下午4:08
 */
public class FindRepeatableNum {
    public static void function(int[] nums){
        if (nums == null || nums.length == 0){
            System.out.println("Empty nums");
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length ; i++) {
            while (nums[i] != i){
                if (nums[nums[i]] == nums[i]){
                    set.add(nums[i]);
                    break;
                }
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        System.out.println(set.toString());
        return;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3,1,3,5};
        function(nums);
    }
}
