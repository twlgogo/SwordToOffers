
/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/18
 * Time: 下午10:20
 */
public class T58LeftRotateChars {
  public static void function(char[] chars, int index) {
    if (chars == null || chars.length == 0) return;
    if (index > 0 && index < chars.length) {
      T58ReverseSentence.reverse(chars, 0, chars.length - 1);
      T58ReverseSentence.reverse(chars, 0, chars.length - 1 - index);
      T58ReverseSentence.reverse(chars, chars.length - index, chars.length - 1);
    }
  }

  public static void main(String[] args) {
    char[] chars = "abcdefg".toCharArray();
    function(chars, 2);
    System.out.println(String.valueOf(chars));
  }

}
