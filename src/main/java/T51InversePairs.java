import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/13
 * Time: 下午9:03
 */
public class T51InversePairs {
  public static int function(int[] nums) {
    if (nums == null || nums.length == 0) return -1;
    int[] copy = Arrays.copyOf(nums, nums.length);

    int count = countHelper(nums, copy, 0, nums.length - 1);
    return count;
  }

  private static int countHelper(int[] nums, int[] copy, int start, int end) {
    if (start == end) {
      copy[start] = nums[start];
      return 0;
    }
    int length = (end - start) / 2;
    int left = countHelper(nums, copy, start, start + length);
    int right = countHelper(nums, copy, start + length + 1, end);
    //i代表第一个数组的最后一个元素 ,j是第二个数组的最后一个元素
    int i = start + length;
    int j = end;
    int indexOfCopy = end;
    int count = 0;
    while (i >= start && j >= start + length + 1) {
      if (nums[i] > nums[j]) {
        copy[indexOfCopy--] = nums[i--];
        count += j - start - length;
      } else {
        copy[indexOfCopy--] = nums[j--];
      }
    }
    while (i >= start) {
      copy[indexOfCopy--] = nums[i--];
    }
    while (j >= start + length + 1) {
      copy[indexOfCopy--] = nums[j--];
    }

    return left + right + count;
  }

  public static void main(String[] args) {
    int[] nums = {7, 5,6,4};
    System.out.println(function(nums));
  }
}
