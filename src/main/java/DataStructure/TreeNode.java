package DataStructure;

import lombok.Data;

/**
 * Created by Intellij
 * User: ttwl
 * Date: 2017/8/5
 * Time: 21:35
 */
@Data
public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(){}
      public TreeNode(int x) { val = x; }
  }
