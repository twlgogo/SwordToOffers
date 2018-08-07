/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/12
 * Time: 下午4:21
 */
public class FindPathInMatrix {
    public static boolean function(char[][] matrix, char[] str){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || str == null || str.length ==0)return false;

        boolean[][] visited= new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if (findCore(matrix,str,i,j,0,visited))
                    return true;
            }
        }
        return false;
    }

    private static boolean findCore(char[][] matrix, char[] str,int row,int col, int pathLength,boolean[][] visited){
        if (str[pathLength] == '\0')
            return true;

        boolean hasPath = false;
        if (row >=0 && row < matrix.length && col >=0 && col <matrix[0].length
                && matrix[row][col] == str[pathLength] && !visited[row][col]){
            pathLength++;
            visited[row][col] = true;

//            hasPath = (row+1<matrix.length && findCore(matrix,str,row+1,col,pathLength,visited))||
//                    (row-1>=0 && findCore(matrix,str,row-1,col,pathLength,visited))||
//                    (col+1<matrix[0].length &&findCore(matrix,str,row,col+1,pathLength,visited))||
//                    (col-1>=0 &&findCore(matrix,str,row,col-1,pathLength,visited));

            hasPath =  findCore(matrix,str,row+1,col,pathLength,visited)||
                findCore(matrix,str,row-1,col,pathLength,visited)||
                   findCore(matrix,str,row,col+1,pathLength,visited)||
                findCore(matrix,str,row,col-1,pathLength,visited);

            if (!hasPath){
                --pathLength;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[][] matrix={{'a','b','t','g'},
                        {'c','f','c','s'},
                        {'j','d','e','h'}};
        char [] str = {'b','z','c','e','\0'};
//        System.out.println(matrix.length);
//        System.out.println(matrix[0].length);
        System.out.println(function(matrix,str));
    }
}
