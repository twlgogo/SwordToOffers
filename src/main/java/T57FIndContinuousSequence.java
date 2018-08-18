/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/18
 * Time: 下午9:09
 */
public class T57FIndContinuousSequence {

  public static void function(int[] nums, int sum) {
    if (nums == null || nums.length == 0) return;
    int small = nums[0], big = nums[1];
    if (sum < small + big) return;
    int middle = (1 + sum) / 2;
    int curSum = small + big;
    while (small < middle) {
      if (curSum == sum) {
        printSequence(small, big);
      }
      while (curSum > sum && small < middle) {
        curSum -= small;
        small ++;
        if (curSum == sum) {
          printSequence(small, big);
        }
      }
      big ++ ;
      curSum += big;
    }
  }

  private static void printSequence(int begin, int end) {
    if (end < begin) return;
    for (int i = begin; i <= end; i++) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,6,7,9,11,13,14,16};
    function(nums,15);
  }
}
