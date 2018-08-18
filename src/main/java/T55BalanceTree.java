import DataStructure.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/16
 * Time: 下午11:17
 */
public class T55BalanceTree {
  public static boolean function(TreeNode root, int[] depthHandler) {
    if (root == null) {
      depthHandler[0] = 0;
      return true;
    }
    int[] left = new int[1];
    int[] right = new int[1];
    if (function(root.left, left)
            && function(root.right, right)) {
      int diff = left[0] - right[0];
      if (diff <= 1 && diff >= -1) {
        depthHandler[0] = 1 + left[0] > right[0] ? left[0] : right[0];
        return true;
      }
    }
    return false;
  }
}
