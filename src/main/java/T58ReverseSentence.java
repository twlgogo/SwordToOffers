import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/18
 * Time: 下午9:31
 */
public class T58ReverseSentence {

  public static void function (char[] chars) {
    if (chars == null || chars.length == 0) return;

    reverse(chars,0,chars.length-1);
    int behind = 0;
    int after = 0;
    while (after <= chars.length -1) {
      if (chars[after] == ' ' ) {
        reverse(chars,behind,after-1);
        behind = ++after ;
      }else if (after == chars.length-1) {
        reverse(chars,behind,after);
      }
      after ++ ;
    }
  }

   static void reverse(char[] chars,int begin, int end) {
    while (begin < end){
      char temp = chars[begin];
      chars[begin] = chars[end];
      chars[end] = temp;
      begin++ ;
      end -- ;
    }
  }

  public static void main(String[] args) {
    char[] test = "I am a student".toCharArray();
    function(test);
    //reverse(test,0,test.length-1);
    System.out.println(String.valueOf(test));
    //String s = String.valueOf(test);
    //reverse(test,0,test.length-1);
    //System.out.println(s);
  }
}
