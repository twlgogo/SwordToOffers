/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/13
 * Time: 下午4:21
 */
public class Power {
    public static boolean invalidFlag = false;
    public static double power(double base,double exponent){
        if (Double.compare(base, 0.0)  == 0 && exponent <= 0){
            invalidFlag = true;
            return 0.0;
        }
        int absExponent = (int) exponent;
        if (exponent < 0.0)absExponent = -absExponent;
        double result = powerCore2(base,absExponent);
        if (exponent < 0.0) result = 1.0/result;
        return result;
    }

    private static double powerCore(double base,int exponent){
        double result = 1.0;
        for (int i = 0; i < exponent ; i++) {
         result *= base;
        }
        return result;
    }

    private static double powerCore2(double base, int exponent){
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        double result = powerCore2(base,exponent>>1);
        result *= result;

        if ((exponent&1) == 1 )
            result *= base;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(2,-3));
        System.out.println(invalidFlag);
    }
}
