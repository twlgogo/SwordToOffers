import DataStructure.TreeNodeWithReverseLink;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/11
 * Time: 下午10:01
 */
public class GetNextNodeofInOrderBinTree {
    public static TreeNodeWithReverseLink function(TreeNodeWithReverseLink node){
        if (node == null){return null;}
        TreeNodeWithReverseLink nextNode = null;
        if (node.right != null){
            //存在右子树的情况下，不断的向下找到右子树的最左子节点
            TreeNodeWithReverseLink rightNode =  node.right;
            while(rightNode.left != null){
                rightNode = rightNode.left;
            }
            nextNode = rightNode;
        }
        else if (node.parent != null){
            //右子树为空，且有父节点
            TreeNodeWithReverseLink currentNode = node;
            TreeNodeWithReverseLink parentNode = node.parent;

            while(currentNode.parent != null && parentNode.right == currentNode){
                currentNode = parentNode;
                parentNode = parentNode.parent;
            }

            nextNode = parentNode;
        }
        return nextNode;
    }
}
