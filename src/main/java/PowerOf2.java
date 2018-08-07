/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/13
 * Time: 下午3:01
 */
public class PowerOf2 {
    public static boolean function(int num){
        return ( num & (num -1))==0 ? true:false;
    }
}
