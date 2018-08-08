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

    public static void adjustMaxHeap(List<Integer> heap, int index){
        int iMax = index ;
        int left = 2*index + 1 ;
        int right = 2*(index + 1) ;

        if (left < heap.size() && heap.get(iMax) < heap.get(left))
            iMax = left;
        if (right < heap.size() && heap.get(iMax) < heap.get(right))
            iMax = right;

        if (iMax != index){
            swap(heap,iMax,index);
            adjustMaxHeap(heap,iMax);
        }
    }

    public static void adjustMinHeap(List<Integer> heap, int index){
        int iMin = index;
        int left = 2*index + 1;
        int right = 2*(index + 1);

        if (left < heap.size() && heap.get(iMin) > heap.get(left))
            iMin = left;

        if (right < heap.size() && heap.get(iMin) > heap.get(right))
            iMin = right;

        if (iMin != index){
            swap(heap,iMin,index);
            adjustMaxHeap(heap,iMin);
        }
    }

    public static void buildMaxHeap(List<Integer> heap){
        int parent = (heap.size() - 2)/2;
        for (int i = parent; i >= 0 ; i--) {
            adjustMaxHeap(heap,i);
        }
    }

    public static void buildMinHeap(List<Integer> heap){
        int parent =(heap.size() - 2)/2;
        for (int i = parent; i >= 0 ; i--) {
            adjustMinHeap(heap,i);
        }
    }

    private static void heapSort(List<Integer> heap){
        buildMaxHeap(heap);
        for (int i = heap.size() - 1; i >= 0  ; i-- ) {
            System.out.println(heap.get(0));
            swap(heap,0,i);
            heap.remove(i);
            adjustMaxHeap(heap,0);
        }
    }

    private static void swap(List<Integer> heap,int i, int j){
        int temp = heap.get(i);
        heap.set(i,heap.get(j)) ;
        heap.set(j,temp);
    }

    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<Integer>();
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(21);
        heap.add(5);
        heap.add(9);
        heap.add(22);
        buildMaxHeap(heap);
        heapSort(heap);
    }
}
