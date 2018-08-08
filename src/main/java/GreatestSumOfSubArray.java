/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/8
 * Time: 下午9:53
 */
public class GreatestSumOfSubArray {
    public static int function(int[] arrays){
        if (arrays == null || arrays.length == 0)return -1;
        int max = Integer.MIN_VALUE;
        int cur = arrays[0];
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] <= 0 )
                cur = arrays[i];
            else cur += arrays[i];
            if (cur > max)
                max = cur;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(function(nums));
    }
}
