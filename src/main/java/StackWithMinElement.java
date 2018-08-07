import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/30
 * Time: 下午9:54
 */
public class StackWithMinElement {

    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public void push(int num){
        stackData.push(num);
        if (stackMin.empty() || num < stackMin.peek()){
            stackMin.push(num);
        }
        else {
            stackMin.push(stackMin.peek());
        }
    }

    public int pop() throws Exception{
        if (stackMin.empty() || stackData.empty())
            throw new Exception();
        stackMin.pop();
        return stackData.pop();
    }

    public int min() throws Exception{
        if (stackMin.empty() || stackData.empty())
            throw new Exception();
        return stackMin.peek();
    }

    public static void main(String[] args) {
        StackWithMinElement stackWithMinElement = new StackWithMinElement();
        try {
            stackWithMinElement.push(4);
            stackWithMinElement.push(3);
            stackWithMinElement.push(1);
            stackWithMinElement.push(5);
            stackWithMinElement.push(2);
            System.out.println(stackWithMinElement.min());
            System.out.println(stackWithMinElement.pop());
            System.out.println(stackWithMinElement.pop());
            System.out.println(stackWithMinElement.pop());
            System.out.println(stackWithMinElement.min());


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
