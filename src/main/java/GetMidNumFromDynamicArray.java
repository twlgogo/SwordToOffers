import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/7
 * Time: 下午11:00
 */
public class GetMidNumFromDynamicArray {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15,(num1,num2)->num2-num1);
    private static volatile int count = 0;

    public synchronized void insert(Integer num){
        count++;
        if ((count&1) == 0){
            if (maxHeap.size() > 0 && num < maxHeap.peek()){
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        }else {
            if (minHeap.size() > 0 && num > minHeap.peek()){
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        }
    }
    public Double getMedian(){
        if ((count&1) == 0){
            return (double) (minHeap.peek()+maxHeap.peek())/2;
        }else return (double)maxHeap.peek();
    }


    public static void main(String[] args) {
        GetMidNumFromDynamicArray getMidNumFromDynamicArray = new GetMidNumFromDynamicArray();
        Random random = new Random(42);
        for (int i = 0; i < 100 ; i++) {
            try{
                int newRandom = random.nextInt(100);
                getMidNumFromDynamicArray.insert(newRandom);
                System.out.println(newRandom+" "+getMidNumFromDynamicArray.getMedian());
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println("false");
            }
        }
    }
}
