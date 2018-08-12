import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/12
 * Time: 下午2:21
 */
public class T48LongestSubstringWithoutDuplication {
  public static String funtion(String str){
    char[] chars = str.toCharArray();
    Map<Character,Integer> map = new HashMap<>();
    for (char ch:chars) {
      map.put(ch,-1);
    }
    int length = chars.length;
    int begin = 0;
    int curMaxLength = 1;
    int []lengths = new int[length];
    for (int i = 0; i < length; i++) {
      if (i > 0)curMaxLength = lengths[i-1];
      char temp = chars[i];
      if (map.get(temp) == -1){
        if (i > 0)lengths[i] = lengths[i-1] + 1;
        else lengths[i] = 1;
      }else {
        int d = i - map.get(temp);
        if (d <= lengths[i-1])
          lengths[i] = d;
        else lengths[i] = lengths[i-1]+1;
      }
      map.put(temp,i);
      if (lengths[i] > curMaxLength){
        curMaxLength = lengths[i];
        begin = i - curMaxLength + 1;
      }
    }
    System.out.println(Arrays.toString(lengths));
    return str.substring(begin,begin+curMaxLength);
  }

  public static void main(String[] args) {
    String str = "arabcacfr";
    System.out.println(funtion(str));
  }
}
