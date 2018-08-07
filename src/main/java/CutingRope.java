/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/13
 * Time: 下午2:09
 */
public class CutingRope {
    public static int function(int length){
        if (length < 2)return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        int[] products = new int[length+1];
        for (int i = 0; i <= 3 ; i++) {
            products[i] = i;
        }

        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <i ; j++) {
                if (max < products[j]*products[i-j])
                    max = products[j]*products[i-j];
            }
            products[i] = max;
        }
        return products[length];
    }

    public static int function2(int length){
        if (length < 2)return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        int timesOf3 = length/3;
        if ((length - timesOf3*3) == 1)
            timesOf3--;

        int timesOf2 = (length - timesOf3 *3)/2;

        double result = Math.pow(3,timesOf3)*Math.pow(2,timesOf2);
        return (int)result;

    }

    public static void main(String[] args) {
        for (int i = 0; i <20 ; i++) {
            if (function(i)!=function2(i))
                System.out.println("Error!!!");
        }
        System.out.println("Success!!!");
    }
}
