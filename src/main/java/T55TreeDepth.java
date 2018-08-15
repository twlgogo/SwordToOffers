import DataStructure.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/15
 * Time: 下午11:07
 */
public class T55TreeDepth {

  public static int functio(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = functio(root.left);
    int rightDepth = functio(root.right);
    return leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1);
  }
}
