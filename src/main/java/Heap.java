import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/29
 * Time: 下午9:40
 */
public class Heap {

    public static void adjustHeap(List<Integer> heap, int index){
        int iMax = index ;
        int left = 2*index + 1 ;
        int right = 2*(index + 1) ;

        if (left < heap.size() && heap.get(iMax) < heap.get(left))
            iMax = left;
        if (right < heap.size() && heap.get(iMax) < heap.get(right))
            iMax = right;

        if (iMax != index){
            swap(heap,iMax,index);
            adjustHeap(heap,iMax);
        }
    }

    public static void buildHeap(List<Integer> heap){
        int parent = (heap.size() - 2)/2;
        for (int i = parent; i >= 0 ; i--) {
            adjustHeap(heap,i);
        }
    }

    private static void heapSort(List<Integer> heap){
        buildHeap(heap);
        for (int i = heap.size() - 1; i >= 0  ; i-- ) {
            System.out.println(heap.get(0));
            swap(heap,0,i);
            heap.remove(i);
            adjustHeap(heap,0);
        }
    }

    private static void swap(List<Integer> heap,int i, int j){
        int temp = heap.get(i);
        heap.set(i,heap.get(j)) ;
        heap.set(j,temp);
    }

    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(21);
        heap.add(5);
        heap.add(9);
        heap.add(22);
        buildHeap(heap);
        heapSort(heap);
//        while (heap.size()!= 0){
//            System.out.println(heap.remove(0));
//        }
    }
}
