/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/17
 * Time: 下午10:49
 */
public class PatternRegularExpression {

    public boolean function(char[] str, char[] pattern){
        if (str== null || pattern == null || str.length == 0 || pattern.length == 0)return false;
        return matchCore(str,0,pattern,0);
    }

    private boolean matchCore(char[] str, int indexStr, char[] pattern ,int indexPattern){
        //字符串与pattern都刚好匹配完成，则两者能够匹配
        if (indexStr == str.length && indexPattern == pattern.length){
            return true;
        }
        //字符串没有匹配完成，而表达式匹配完了，则不能匹配
        if (indexStr != str.length && indexPattern == pattern.length)
            return false;

        //pattern的下一个字符是*的情况，可能有三种，匹配0次，匹配1次，匹配多次
        if (pattern[indexPattern+1]=='*'){
            if ((indexStr != str.length && str[indexStr] == pattern[indexPattern])||(pattern[indexPattern] =='.' && indexStr!=str.length)){
                //匹配一次
                return matchCore(str,indexStr+1,pattern,indexPattern+2)||
                        //匹配0次
                        matchCore(str,indexStr,pattern,indexPattern+2)||
                        //匹配多次
                        matchCore(str,indexStr+1,pattern,indexPattern);
            }else {
                //该字符不匹配的情况
                return matchCore(str,indexStr,pattern,indexPattern+2);
            }


        }

        if ((str[indexStr] == pattern[indexPattern] && indexStr != str.length)|| (pattern[indexPattern] == '.'&& indexStr != str.length))
            return matchCore(str,indexStr+1,pattern,indexPattern+1);
        return false;
    }

    public static void main(String[] args) {
        PatternRegularExpression p = new PatternRegularExpression();
        String str = "a";
        String pattern = "a*";
        System.out.println(p.function(str.toCharArray(),pattern.toCharArray()));
    }
}
