/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/17
 * Time: 下午10:08
 */
public class T56FindNumAppearOnlyOnce {
  public static int function(int[] num) {
    if (num == null || num.length == 0)
      throw new IllegalArgumentException("输入数组为空");
    int [] bits = new int[32];
    System.out.println(bits[21]);
    for (int i = 0; i < num.length; i++) {
      int bitMask = 1;
      for (int j = 31; j >=0 ; j--) {
        int bit = num[i] & bitMask;
        if (bit != 0)
          bits[j] += 1;
        bitMask = bitMask << 1;
      }
    }
    int result = 0;
    for (int i = 0; i <32 ; i++) {
      result = result << 1;
      result += bits[i] % 3;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] num = {1,1,1,2};
    System.out.println(function(num));
  }
}
