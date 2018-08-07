import DataStructure.TreeNode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/31
 * Time: 下午9:48
 */
public class ZPrintTree {
    public static void function(TreeNode root){
        if (root == null)return;
        int current = 0;
        int next = 1;
        Stack<TreeNode>[] stacks= new Stack[2];
        stacks[0] = new Stack<TreeNode>();
        stacks[1] = new Stack<TreeNode>();
        stacks[current].push(root);
        while (!stacks[0].empty() && !stacks[1].empty()){
            TreeNode curTreeNode  = stacks[current].pop();
            System.out.print(curTreeNode.val);

            if (current == 0){
                if (curTreeNode.left != null)
                    stacks[next].push(curTreeNode.left);
                if (curTreeNode.right != null)
                    stacks[next].push(curTreeNode.right);
            }else {
                if (curTreeNode.right != null)
                    stacks[next].push(curTreeNode.right);
                if (curTreeNode.left != null)
                    stacks[next].push(curTreeNode.left);
            }
            if (stacks[current].empty()){
                System.out.println();
                current = 1- current;
                next = 1- next;
            }
        }

    }

    public static void main(String[] args) {
        Stack<Integer>[] stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[0].push(1);
        System.out.println(stacks[0].pop());
    }
}
