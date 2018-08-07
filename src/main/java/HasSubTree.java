import DataStructure.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/29
 * Time: 下午12:14
 */
public class HasSubTree {

    public  boolean function(TreeNode t1,TreeNode t2){
        boolean result = false;
        if (t1 != null && t2 != null){
            if (t1.val == t2.val)
                result = doesT1HaveT2(t1,t2);
            if (!result)
                result = doesT1HaveT2(t1.left,t2);
            if (!result)
                result = doesT1HaveT2(t1.right,t2);
        }
        return result;
    }

    private   boolean doesT1HaveT2(TreeNode t1,TreeNode t2){
        if (t1 == null)return true;
        if (t2 == null)return true;
        if (t1.val != t2.val) return false;
        return doesT1HaveT2(t1.left,t2.left)&&doesT1HaveT2(t1.right,t2.right);

    }
}
