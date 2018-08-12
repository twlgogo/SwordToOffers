import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/12
 * Time: 下午3:06
 */
public class T50FirstNotReatingChar {
  public static char function(String str){
    if (str == null || str.length() == 0)return '1';
    Map<Character,Integer> map = new HashMap<>();
    char[] chars = str.toCharArray();
    for (char ch:chars) {
      map.merge(ch,1,(a,b)->a+1);
//      map.put(ch,map.getOrDefault(ch,0)+1);
    }
    for (char ch:chars) {
      if (map.get(ch) == 1)
        return ch;
    }
    return '1';
  }

  public static void main(String[] args) {
    System.out.println(function("abaccdeff"));
  }
}
