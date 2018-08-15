import DataStructure.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/15
 * Time: 下午11:00
 */
public class T54KthNodeInBST {
  public static TreeNode function(TreeNode root, int k){
    if (root == null || k <= 0) {
      return null;
    }
    return findHelper(root, k);
  }

  private static TreeNode findHelper(TreeNode root, int k) {
    TreeNode target = null ;
    if (root.left != null){
      target = findHelper(root.left, k);
    }
    if (target == null){
      if (k == 1)
        target = root;

      k--;
    }
    if (target == null && root.right != null){
      target = findHelper(root.right, k);
    }
    return target;
  }
}
