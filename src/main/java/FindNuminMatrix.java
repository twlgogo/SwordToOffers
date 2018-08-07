/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/10
 * Time: 下午4:47
 */
public class FindNuminMatrix {
    public static boolean function(int[][] matrix , int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)return false;
        int indexRow = 0 , indexColumn = matrix[0].length-1;
        while (indexColumn > 0 || indexRow < matrix.length){
            if (matrix[indexRow][indexColumn] > target){
                indexColumn--;continue;
            }else if (matrix[indexRow][indexColumn] < target){
                indexRow++;continue;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrixs = {{1,2,8,9},{1,2,3,4},{4,7,10,13},{6,8,11,15}};

        System.out.println(function(matrixs,7));
    }
}
