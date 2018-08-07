/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/10
 * Time: 下午10:46
 */
public class ReplaceSpace {
    private static int countSpace(char[] chars){
        int result = 0;
        for (int i = 0; i < chars.length ; i++) {
            if (chars[i] == ' ')result++;
            else continue;
        }
        return result;
    }

    private static char[] function(char[] chars) throws Exception{
        if (chars == null || chars.length == 0)throw new Exception();
        int numofSpace = countSpace(chars);
        if (numofSpace == 0)return chars;
        int p1 = chars.length - 1, p2 = chars.length + numofSpace*2 - 1;
        char[] result = new char[p2 + 1];
        while(p1 != p2){
            if (chars[p1] != ' ') result[p2--] = chars[p1--];
            else{
                p1--;
                result[p2--] = '0';
                result[p2--] = '2';
                result[p2--] = '%';
            }
        }
        while(p1 >= 0){
            result[p2--] = chars[p1--];
        }
        return result;
    }

    public static void main(String[] args) {
        String rawTest = "  ";
        char[] test = rawTest.toCharArray();
        try{
            System.out.println(function(test));
        }catch (Exception e){ e.printStackTrace();}
    }
}
