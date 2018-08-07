import DataStructure.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/11
 * Time: 下午5:31
 */
public class CreateBinTreeFromInOrderandPreOrder {
    public static TreeNode function(int[] preOrder,int[] inOrder){
        if (preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0)return null;
        if (preOrder.length != inOrder.length)return null;

        return creatCore(preOrder,0,preOrder.length -1 ,inOrder,0,inOrder.length -1 );
    }
    private static TreeNode creatCore(int[] preOrder, int startPre,int endPre,int[] inOrder,int startIn,int endIn){
        if ((endPre - startPre) != (endIn - startIn))return null;
        if (preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0)return null;
        int rootVal = preOrder[startPre];
        TreeNode root = new TreeNode(rootVal);
        if (startPre == endPre && startIn == endIn)return root;
        
        //查找根节点在中序遍历中的位置，count记录左子树的大小
        int rootIndex = -1, count = 0;
        for (int i = startIn; i <= endIn; i++,++count) {
            if (rootVal == inOrder[i]){
                rootIndex = i;
                break;
            }
        }

        if (rootIndex == -1)return null;

        //构建左子树
        if (count > 0){
            root.left = creatCore(preOrder,startPre+1,startPre+count,inOrder,startIn,rootIndex-1);
        }

        //构建右子树
        if (endPre > startPre + count){
            root.right = creatCore(preOrder,startPre+count+1,endPre,inOrder,rootIndex+1,endIn);
        }
        return root;
    }

    private static TreeNode constructe(int[] preOrder, int startPre, int endPre, int[] inOrder,
                                int startIn, int endIn) {
        if ((endPre - startPre) != (endIn - startIn)) {
            return null;
        }
        if (preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }
        // 前序遍历的第一个节点为根节点
        int rootValue = preOrder[startPre];
        TreeNode root = new TreeNode(rootValue);

        // 只有一个元素，返回该节点
        if (startPre == endPre && startIn == endIn) {
            return root;
        }

        int rootIdx = -1, count = 0;
        // 遍历中序遍历结果，找到根节点的值
        for (int i = startIn; i <= endIn; ++i, ++count) {
            if (rootValue == inOrder[i]) {
                rootIdx = i;
                break;
            }
        }

        // 没有在中序遍历中找到该节点。
        if (rootIdx == -1) {
            return null;
        }

        if (count > 0) {
            // 构建左子树
            root.left = (constructe(preOrder, startPre + 1, startPre + count, inOrder, startIn,
                    rootIdx - 1));
        }

        if (endPre > startPre + count) {
            // 构建右子树
            root.right = (constructe(preOrder, startPre + count + 1, endPre, inOrder,
                    rootIdx + 1, endIn));
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder1 = new int[] {
                1, 2, 4, 7, 3, 5, 6, 8
        };
        int[] inOrder1 = new int[] {
                4, 7, 2, 1, 5, 3, 8, 6
        };

        TreeNode root = function(preOrder1,inOrder1);

        PrintTreeInLevel.function(root);
    }
}
