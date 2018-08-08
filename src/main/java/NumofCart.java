import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/22
 * Time: 下午7:21
 */
public class NumofCart {

    public static void function(int[] carts){
        Arrays.sort(carts);
        int count = 0;
        int indexof100 = 0;
        while (carts[indexof100] ==100 && indexof100<carts.length-1)indexof100++;
        count = indexof100/3;
        indexof100 = count * 3;
        int indexof200 = carts.length -1 ;
        while(carts[indexof200] > 200) {
            indexof200-- ;
            count++;
        }
        int a = indexof100 , b = indexof200;
        while(a<b){
            if (carts[a] + carts[b]<=300){
                count++ ;
                a++;
                b--;
            }else {
                count++;
                b--;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] carts ={100,100,100};
        function(carts);
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new LinkedList<Integer>();
        while (sc.hasNext()){
            list.add(sc.nextInt());
        }
        int[] carts = new int[list.size()];
        int i = 0;
        for (int a:list) {
            carts[i++] = a;
        }
        Arrays.sort(carts);
        int count = 0;
        int indexof100 = 0;
        while (carts[indexof100] ==100&& indexof100<carts.length-1)indexof100++;
        count = indexof100/3;
        indexof100 = count * 3;
        int indexof200 = carts.length -1 ;
        while(carts[indexof200] > 200) {
            indexof200-- ;
            count++;
        }
        int a = indexof100 , b = indexof200;
        while(a<b){
            if (carts[a] + carts[b]<=300){
                count++ ;
                a++;
                b--;
            }else {
                count++;
                b--;
            }
        }
        System.out.println(count);
    }
}
