import DataStructure.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/29
 * Time: 下午12:26
 */
public class MirrorTree {

    public static void funtion(TreeNode root){
        if (root == null)return;
        if (root.left == null && root.right == null)return;

        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        if (root.left != null)
            funtion(root.left);
        if (root.right != null)
            funtion(root.right);

    }
}
