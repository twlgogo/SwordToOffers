import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/5
 * Time: 下午1:32
 */
public class CharPermutation {
    public static void function(char[] chars){
        if(chars == null || chars.length == 0)return;
        Permutation(chars,0);
    }
    public static void Permutation(char[] chars, int index){
        if(index == chars.length)
            System.out.println(Arrays.toString(chars));

        else {
            for (int i = index; i <chars.length ; i++) {
                char temp = chars[index];
                chars[index] = chars[i];
                chars[i] = temp;
                Permutation(chars,index+1);
                temp = chars[index];
                chars[index] = chars[i];
                chars[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        char[] chars ={'a','b','c'};
        function(chars);
        System.out.println(Arrays.toString(chars));
    }
}
