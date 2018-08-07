import DataStructure.TreeNode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/3
 * Time: 下午9:45
 */
public class FindPath {
    public static void function(TreeNode root, int expectedVal){
        if (root == null )return;
        int curSum = 0;
        findHelper(root,curSum,expectedVal,new Stack<>());

    }
    private static void findHelper(TreeNode currNode, int curSum, int expectedVal, Stack<Integer> pathStack){
        curSum += currNode.val;
        pathStack.push(currNode.val);
        boolean isLeafNode = currNode.left == null && currNode.right == null;
        if (isLeafNode && curSum == expectedVal){
            printHelper(pathStack);
        }
        if (currNode.left != null){
            findHelper(currNode.left,curSum,expectedVal,pathStack);
        }
        if (currNode.right != null){
            findHelper(currNode.right,curSum,expectedVal,pathStack);
        }
        pathStack.pop();
    }

    private static void printHelper(Stack<Integer> stack){
        for (Integer item :stack) {
            System.out.println(item);
        }
    }


}
