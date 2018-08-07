/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/30
 * Time: 下午9:11
 */
public class PrintMatrixClockwisely {

    public static void function (int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int columns = matrix[0].length;
        int rows = matrix.length;
        int start = 0;

        while (columns > start * 2 && rows > start *2){
            printInCycle(matrix,start);
            ++start;
        }
    }

    private static void printInCycle(int[][] matrix, int start){
        int endX = matrix[0].length - 1 - start;
        int endY = matrix.length - 1 - start;

        for (int i = start ; i <= endX ; i++) {
            System.out.println(matrix[start][i]);
        }

        if (endY > start){
            for (int i = start + 1; i <= endY ; i++) {
                System.out.println(matrix[i][endX]);
            }
        }

        if (endY > start && endX > start){
            for (int i = endX - 1 ; i >= start ; i--) {
                System.out.println(matrix[endY][i]);
            }
        }

        if (endX - start > 2){
            for (int i = endY - 1; i > start ; i--) {
                System.out.println(matrix[i][start]);
            }
        }

    }

    public static void main(String[] args) {
        //int[][] numbers = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] numbers = {{}};
        function(numbers);
    }
}
