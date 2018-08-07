/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/13
 * Time: 下午2:35
 */
public class NumsOf1 {
    public static int function(int num){
        int flag = 1 ,count = 0;
        while(flag != 0){
            if ((num & flag) == flag) count++;
            flag = flag << 1;
        }
        return count;
    }

    public static int function2(int num){
        int flag = 1 ,count = 0;
        while(flag != 0){
            if ((num & flag) != 0) count++;
            flag = flag << 1;
        }
        return count;
    }

    public static int function3(int num){
        /**
         * 一个非常神奇的解法
         * 将一个数字减去1以后，相当于这个数字最右面1之后的0全部变成1，最右面的1变成0，1的左侧位不变
         * 再将得到的结果和原来的数字做与运算，则得到的结果只将最右侧的1变为0
         * 这种很骚的解放可以解决不少问题，比如判断一个数是否是2的整数次方
         */
        int count = 0;
        while(num!=0){
            count ++;
            num = num&(num-1);
        }
        return count;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 65535 ; i++) {
//            if(function(i)!=function2(i))
//                System.out.println("Error"+i);
//        }
        System.out.println(function3(7));
    }
}
