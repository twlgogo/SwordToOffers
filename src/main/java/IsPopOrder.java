import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/31
 * Time: 下午9:27
 */
public class IsPopOrder {
    public static boolean function(int[] push,int [] pop){
        if (push == null || push.length == 0 )return false;
        if (pop == null || pop.length == 0 )return false;
        if (push.length != pop.length) return false;
        boolean result = false;

        int indexPush = 0;
        int indexPop = 0;
        Stack<Integer> stack = new Stack<>();
        while (indexPop < pop.length){
            while (stack.empty() || stack.peek() != pop[indexPop]){
                if (indexPush == push.length) break;
                stack.push(push[indexPush]);
                indexPush++;
            }
            if (stack.peek() != pop[indexPop]){
                break;
            }
            stack.pop();
            indexPop++;
        }

        if (stack.empty()&&indexPop == pop.length)
            result = true;

        return result;
    }

    public static void main(String[] args) {
        int[] pop = {4,3,5,1,2};
        int[] push = {1,2,3,4,5};
        System.out.println(function(push,pop));
    }
}
