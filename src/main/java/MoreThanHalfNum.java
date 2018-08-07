import Exception.EmptyArrayException;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/6
 * Time: 下午10:35
 */
public class MoreThanHalfNum {
    public static int function(int[] nums) throws EmptyArrayException {
        if (nums == null || nums.length == 0)
            throw new EmptyArrayException("数组为空");
        int times = 0;
        int res = nums[0];

        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == res){
                times ++ ;
            }else {
                times--;
            }
            if (times == 0){
                res = nums[i];
                times ++ ;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] array = {2,2,2,2,1,3};
        int[] array1 = {};
        try {
            System.out.println(function(array1));

        }catch (Exception e){
            System.out.println("不处理");
        }
    }
}
