import DataStructure.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/4
 * Time: 下午4:03
 */
public class BST2DLL {
    /**
     * 将二叉搜索树转化成有序双向链表
     */

    public static TreeNode function(TreeNode root){
        if (root == null)return root;

        TreeNode[] lastNode = new TreeNode[1];
        covertHelper(root,lastNode);
        TreeNode listHead = root;
        while(listHead.left != null){
            listHead = listHead.left;
        }

        return listHead;
    }

    private static void covertHelper(TreeNode root, TreeNode[] lastNode){
        if (root == null)return;
        if (root.left != null){
            covertHelper(root.left,lastNode);
        }

        root.left = lastNode[0];
        if (root.left != null)
            lastNode[0].right = root;
        lastNode[0] = root;

        if (root.right != null){
            covertHelper(root.right,lastNode);
        }

    }

    public static void main(String[] args) {

        int []in = {4,6,8,10,12,14,16};
        int []pre = {10,6,4,8,14,12,16};

        TreeNode root = CreateBinTreeFromInOrderandPreOrder.function(pre,in);
        PrintTreeInLevel.function(root);

        TreeNode head = function(root);
        while (head != null){
            System.out.println(head.val);
            head = head.right;
        }

    }
}
