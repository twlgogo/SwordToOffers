import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/18
 * Time: 下午10:06
 */
public class SwapOddandEven {
    public static void function(int[] arrays){
        if (arrays == null || arrays.length == 0)return;
        int indexBegin = 0 ,indexEnd = arrays.length - 1;
        while(indexBegin < indexEnd){
            while (indexBegin < indexEnd && (arrays[indexBegin]&0x1) != 0)
                indexBegin++;
            while(indexBegin < indexEnd && (arrays[indexEnd]&0x1) == 0)
                indexEnd--;

            if (indexBegin<indexEnd){
                int swap = arrays[indexBegin];
                arrays[indexBegin] = arrays[indexEnd];
                arrays[indexEnd] = swap;
            }
        }
    }

    public static void main(String[] args) {
        int[] arrays = {1,2,3,4,5};
        function(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
