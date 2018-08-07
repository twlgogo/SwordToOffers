/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/3
 * Time: 下午8:36
 */
public class SequenceOfBST {

    public static boolean function(int []treeSequence, int curLength){
        if (treeSequence == null || treeSequence.length == 0)return false;
        int root = treeSequence[curLength - 1];

        int i = 0;
        for (; i < curLength -1 ;i++){
            if (treeSequence[i] > root)
                break;
        }

        int j = i;
        for (; j < curLength -1 ; j++){
            if (treeSequence[j] < root)
                return false;
        }

        boolean left = true;
        if (i > 0){
            left = function(treeSequence, i);
        }
        boolean right = true;
        if (i < curLength -1){
            right = function(treeSequence ,curLength - i - 1);
        }
        return (left&&right);
    }

    public static void main(String[] args) {
        int[] treeSequence = {7,4,6,5};
        System.out.println(function(treeSequence,treeSequence.length));
    }
}
