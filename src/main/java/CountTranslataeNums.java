/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/11
 * Time: 下午2:08
 */
public class CountTranslataeNums {

  public static int function(String rawInput){
    char[] chars = rawInput.toCharArray();
    int length = chars.length;
    int [] counts = new int[length];
    int count = 0;
    for (int i = length -1; i >=0 ; i--) {
      count = 0;
      if (i < length - 1){
        count = counts[i+1];
      }else count = 1;
      if (i < length - 1){
        int num1 = chars[i] - '0';
        int num2 = chars[i+1] - '0';
        if ((num1*10 + num2)>=10 && (num1*10 + num2)<=25){
          if (i < length - 2) count += counts[i+2];
          else count += 1;
        }
      }
      counts[i] = count;
    }
    return counts[0];
  }

  public static void main(String[] args) {
    System.out.println(function("12258"));
  }
}
