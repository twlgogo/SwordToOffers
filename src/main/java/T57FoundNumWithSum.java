/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/18
 * Time: 下午9:01
 */
public class T57FoundNumWithSum {
  public static void function(int[] nums, int sum) {
    if (nums == null || nums.length == 0) return;
    int left = 0, right = nums.length - 1;
    while (left < right) {
      if (nums[left] + nums[right] < sum) {
        left++;
      } else if (nums[left] + nums[right] > sum) {
        right--;
      } else {
        break;
      }
    }
    if (left >= right) {
      return;
    }
    System.out.println(nums[left]);
    System.out.println(nums[right]);
  }

  public static void main(String[] args) {
    int[] nums = {1,2,4,7,11,15};
    function(nums,3);
  }
}
