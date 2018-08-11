import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/10
 * Time: 下午6:17
 */
public class MinNumOfArrays {
  /**
   * 给定一组数，输出这一组数可以拼接成的最小数
   */

  private static class MinComparatotr implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
      if (o1  == null || o2 == null)
        throw new IllegalArgumentException("参数为空");
      String s1 = o1 + o2;
      String s2 = o2 + o1;
      return s1.compareTo(s2);
    }
  }

  private static void quickSort(String[] strings, int start, int end, Comparator<String> comparator) {
    if (strings == null || strings.length == 0)
      throw new IllegalArgumentException("输入的String为空");

    if (start < end) {
      int i = start, j = end;
      String keyString = strings[start];
      while (i < j) {
        while (i < j && comparator.compare(strings[i], strings[j]) <= 0) j--;
        if (i < j) strings[i] = strings[j];
        while (i < j && comparator.compare(strings[i], strings[j]) >= 0) i++;
        if (i < j) strings[j] = strings[i];
      }
      strings[i] = keyString;
      if (i - 1 > start) quickSort(strings, start, i - 1, comparator);
      if (end > j + 1) quickSort(strings, i + 1, end, comparator);
    }
  }

  private static String linkStrings(String[] strings){
    StringBuilder sb = new StringBuilder(256);
    for (String str: strings) {
      sb.append(str);
    }
    return sb.toString();
  }
  
  public static String function (int [] nums){
    if (nums == null || nums.length == 0)
      throw new IllegalArgumentException("输入的数组为null");
    String[] temp = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      temp[i] = String.valueOf(nums[i]);
    }
    quickSort(temp,0,temp.length-1,new MinComparatotr());
    return linkStrings(temp);
  }

  public static void main(String[] args) {
    int[] nums = {};
    System.out.println(function(nums));
  }
}
