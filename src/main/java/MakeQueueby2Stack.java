import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/11
 * Time: 下午10:51
 */
public class MakeQueueby2Stack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void offer(int element){
        stack1.push(element);
    }

    public int poll()throws Exception{
        if (stack1.isEmpty() && stack2.isEmpty())throw new Exception();
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
/*        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());*/

        MakeQueueby2Stack queueby2Stack = new MakeQueueby2Stack();
        queueby2Stack.offer(1);
        queueby2Stack.offer(2);
        queueby2Stack.offer(3);

        try{
            System.out.println(queueby2Stack.poll());
            System.out.println(queueby2Stack.poll());
            System.out.println(queueby2Stack.poll());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
