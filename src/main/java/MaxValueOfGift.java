/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/11
 * Time: 下午10:06
 */
public class MaxValueOfGift {
  public static void main(String[] args) {
    int[][] gifts = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
    int[][] gifts2 = {{1,2,3,4}};
    System.out.println(function(gifts2));
  }
  private static int function(int[][] gifts){
    if (gifts == null || gifts.length == 0 || gifts[0].length == 0)
      return 0;
    int rows = gifts.length;
    int cols = gifts[0].length;
    int[][] maxvalues = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int fromLeft = 0;
        int fromUp = 0;
        if (i > 0)
          fromLeft = maxvalues[i-1][j];
        if (j > 0)
          fromUp = maxvalues[i][j-1];
        maxvalues[i][j] = Math.max(fromLeft,fromUp) + gifts[i][j];
      }
    }
    return maxvalues[rows - 1][cols - 1];
  }
}
