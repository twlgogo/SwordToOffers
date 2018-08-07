/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/12
 * Time: 下午1:47
 */
public class Fibonacci {
    public static long function(int n){
        if (n < 0)return -1;
        if (n < 2)return n == 0? 0:1;

        long fabN_1 = 1;
        long fabN_2 = 0;
        long fabN = -1;
        for (int i = 2; i <= n; i++) {
            fabN = fabN_1+ fabN_2;

            fabN_2 = fabN_1;
            fabN_1 = fabN;
        }
        return fabN;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println(function(i));

        }
    }
}
