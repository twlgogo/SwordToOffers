import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/6
 * Time: 下午9:54
 */
public class QuickSort {

    public void function(int[] arrays, int start ,int end){
        int i = start, j = end;
        int key = arrays[start];
        while (i < j){
            while (arrays[j] >= key && i < j)j--;
            if (i<j){arrays[i] = arrays[j];}

            while (arrays[i] < key && i < j )i++;
            if (i<j){arrays[j] = arrays[i];}


            arrays[i] = key;
        }
        if (i-1 > start){
            function(arrays,start,i-1);
        }
        if (end > i+1){
            function(arrays,i+1,end);
        }
    }

    public static void main(String[] args) {
        int[] arrays = {2,34,1,3,6,9,5,0,1};
        QuickSort quickSort = new QuickSort();
        quickSort.function(arrays,0,arrays.length-1);
        System.out.println(Arrays.toString(arrays));
    }
}
