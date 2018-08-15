/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/15
 * Time: 下午10:33
 */
public class T53TimesofNumInSortedArray {
  public static int function(int[] data, int k) {
    if (data == null || data.length == 0) {
      return -1;
    }
    int start = getFirstK(data, 0, data.length - 1, k);
    int end = getLastK(data, 0, data.length - 1, k);
    return end - start + 1;
  }

  public static void main(String[] args) {
    int[] data = {1, 2, 3, 3, 4, 5};
    System.out.println(function(data, 3));
  }

  private static int getFirstK(int[] data, int start, int end, int k) {
    if (start > end) {
      return -1;
    }
    int midIndex = (start + end) / 2;
    int midData = data[midIndex];
    if (midData == k) {
      if ((midIndex > 0 && data[midIndex - 1] != k)
              || midIndex == 0) {
        return midIndex;
      } else
        end = midIndex - 1;
    } else if (midData > k) {
      end = midIndex - 1;
    } else {
      start = midIndex + 1;
    }
    return getFirstK(data, start, end, k);
  }

  private static int getLastK(int[] data, int start, int end, int k) {
    if (start > end) {
      return -1;
    }
    int midIndex = (start + end) / 2;
    int midData = data[midIndex];
    if (midData == k) {
      if ((midIndex < data.length - 1 && data[midIndex + 1] != k)
              || midIndex == data.length - 1) {
        return midIndex;
      } else
        start = midIndex + 1;
    } else if (midData < k) {
      start = midIndex + 1;
    } else {
      end = midIndex - 1;
    }
    return getLastK(data, start, end, k);
  }
}
