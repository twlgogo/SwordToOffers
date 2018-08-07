import DataStructure.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/29
 * Time: 下午4:28
 */
public class SymmetricalTree {
    public static boolean function(TreeNode treeNode){
        return isSymmetrical(treeNode,treeNode);
    }

    private static boolean isSymmetrical(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null)return true;
        if (t1 == null || t2 == null)return false;
        if (t1.val != t2.val)return false;

        return isSymmetrical(t1.left,t2.right)&&isSymmetrical(t1.right,t2.left);
    }
}
