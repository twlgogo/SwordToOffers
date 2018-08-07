/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/12
 * Time: 下午3:38
 */
public class FIindiMInimumnRotatingArray {

    /**
     * 有个比较有意思的bug
     * 当出现{1，1，1，0，1} 和{1，0，1，1，1}时
     * 用下面的算法是无法确定最小的值存在于前面的递增数组还是后面的递增数组的
     * 在这种情况下，即array[start] = array[mid] = array[end]
     * 采用暴力搜索，直接找出最小值
     */
    public static int function(int[] array){
        if (array == null || array.length == 0)return -1;
        int start = 0 , end = array.length-1, mid = start;
        while(end - start != 1){
            if (array[start] <= array[end])
            {
                end = start;
                break;
            }
            if (array[start] <= array[mid]){
                start = mid;
                mid = start + (end - start)/2;
            }
            if (array[end] >= array[mid]){
                end = mid;
                mid = start + (end - start)/2;
            }
        }
        return array[end];
    }

    public static void main(String[] args) {
        int[] array = {4,5,7,8,9,1,2,3};
        int[] array1 = {};
        System.out.println(function(array));
    }
}
