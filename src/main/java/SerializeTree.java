import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/5
 * Time: 下午12:46
 */
public class SerializeTree {

    public static void function(TreeNode root, List<Integer> list){
        if (root == null){
            list.add(null);
            return;
        }

        list.add(root.val);
        function(root.left,list);
        function(root.right,list);
    }

    public static TreeNode deSeserialize(List<Integer> list,int[] indexHolder){
        int index = indexHolder[0];
        /**
         * 有很严重的问题，最终根节点还是没有发生变化
         */
        if (list.get(index) != null && index < list.size()){
            TreeNode root = new TreeNode();
            root.val = list.get(index);
            indexHolder[0]++;
            root.left = deSeserialize(list,indexHolder);
            indexHolder[0]++;
            root.right = deSeserialize(list,indexHolder);
            return root;
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,3,5,6};
        int[] in = {4,2,1,5,3,6};

        TreeNode root = CreateBinTreeFromInOrderandPreOrder.function(pre,in);
        List<Integer> list = new ArrayList<>();
        function(root,list);
        for (Integer elem:list) {
            if (elem != null){
                System.out.print(elem + " ");
            }else {
                System.out.print("null ");
            }
        }
        System.out.println();
        TreeNode root1 = new TreeNode() ;
        int[] indexHolder = {0};
        root1 = deSeserialize(list,indexHolder);
     //   PrintTreeInLevel.function(root);
        PrintTreeInLevel.function(root1);
    }

}
