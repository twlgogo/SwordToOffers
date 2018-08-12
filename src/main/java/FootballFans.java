
import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/12
 * Time: 上午11:10
 */
public class FootballFans {
  static int P = 0;
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] strings = scanner.nextLine().trim().split(",");
    int rows = Integer.parseInt(strings[0]);
    int cols = Integer.parseInt(strings[1]);
    boolean [][] visited = new boolean[rows][cols];
    int [][]fans = new int[rows][cols];
    for (int i = 0; i < rows ; i++) {
      String[] strings2 = scanner.nextLine().trim().split(",");
      for (int j = 0; j < cols ; j++) {
        fans[i][j] = Integer.parseInt(strings2[j]);
        visited[i][j] = false;
      }
    }
    int[] maxFansHandler = {0};
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (visited[i][j] == false && fans[i][j] == 1)
          visitHelper(fans,visited,i,j,maxFansHandler);
      }
    }
    System.out.println(P+","+maxFansHandler[0]);
  }

  private static void visitHelper(int[][] fans, boolean[][] visited, int i, int j, int[] maxFansHandler){
    int rows = fans.length;
    int cols = fans[0].length;
    P++;
    int fansNum = 0;
    Stack<Node> stack = new Stack<>();
    stack.push(new Node(i,j));
    while (!stack.isEmpty()){
      Node curNode = stack.pop();
      visited[curNode.x][curNode.y] = true;
      fansNum++;
      if (curNode.x < rows - 1 && fans[i][j+1] == 1)stack.push(new Node(i,j+1));
      if (curNode.x < rows - 1 && curNode.y < cols - 1 && fans[i+1][j+1] == 1)stack.push(new Node(i+1,j+1));
      if (curNode.y < cols - 1&& fans[i+1][j] == 1)stack.push(new Node(i+1,j));
      if (curNode.y < cols -1 && curNode.x > 0&& fans[i-1][j+1] == 1)stack.push(new Node(i -1 ,j +1));
      if (curNode.x > 0&& fans[i][j-1] == 1)stack.push(new Node(i,j-1));
      if (curNode.x > 0 && curNode.y > 0&& fans[i-1][j-1] == 1)stack.push(new Node(i-1,j-1));
      if (curNode.y > 0&& fans[i-1][j] == 1)stack.push(new Node(i-1,j));
      if (curNode.x < rows -1 && curNode.y > 0&& fans[i+1][j-1] == 1)stack.push(new Node(i+1,j-1));
    }
    if (maxFansHandler[0] < fansNum)
      maxFansHandler[0] = fansNum;
  }


  static class Node {
    int x;
    int y;

    Node(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
}
