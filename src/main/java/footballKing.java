import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/22
 * Time: 下午8:01
 */
public class footballKing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),m=sc.nextInt();
        String [] strings = new String[m];
        for(int i = 0; i < m; i++){
            strings[i] = sc.next();
        }
        char[][] voteRaw = new char[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                voteRaw[i][j] = strings[i].charAt(j);
            }
        }
        int[][] voteMatrix = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                int win = 0, loss = 0;
                for (int k = 0; k < m; k++)
                {
                    if (voteRaw[k][i] < voteRaw[k][j])
                        win++;
                    else if (voteRaw[k][i] > voteRaw[k][j])
                        loss++;
                }
                if (win > loss)
                {
                    voteMatrix[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++)
        {
            int winnumber = 0;
            for (int j = 0; j < n; j++)
            {
                if (voteMatrix[i][j] == 1)
                    winnumber++;
            }
            if (winnumber == n - 1)
            {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);


    }
}
