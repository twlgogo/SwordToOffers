import javafx.scene.transform.MatrixType;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/8
 * Time: 下午10:27
 */
public class digitAtIndex {

    public static int function(int index){
        if (index < 0)return -1;
        for (int digits = 1;; digits++) {
            int count = digits*countOfDigits(digits);
            if (count > index){
                return indexOfNum(index ,digits);
            }
            index -= count;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            System.out.println(function(i));
        }

//        System.out.println(indexOfNum(2,1));
    }

    private static int countOfDigits(int digit){
        if (digit == 1)return 10;
        int count = (int)Math.pow(10,digit-1);
        return 9*count;
    }

    private static int indexOfNum(int index ,int digit){
        int base;
        if (digit == 1){
            base = 0;
        }else {
            base = (int) Math.pow(10,digit -1);
        }

        int num  = index/digit + base;
        int fromRight =  digit - index%digit;
        for (int i = 1; i < fromRight; i++) {
            num /= 10;
        }
        return num%10;
    }
}
