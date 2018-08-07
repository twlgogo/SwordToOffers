import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/4
 * Time: 下午4:21
 */
public class PrintTreeInLevel {
    public static void function(TreeNode root){
        if (root == null)return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nextLevel = 0;
        int tobePrint = 1;

        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            System.out.print(curNode.val+" ");
            tobePrint--;
            if (curNode.left != null){
                queue.offer(curNode.left);
                nextLevel++;
            }
            if (curNode.right != null){
                queue.offer(curNode.right);
                nextLevel++;
            }

            if (tobePrint == 0){
                System.out.println();
                tobePrint = nextLevel;
                nextLevel = 0;
            }
        }
    }

    public static void main(String[] args) {

    }
}
