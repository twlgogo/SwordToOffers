import java.awt.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/8
 * Time: 下午8:41
 */
public class AliShortest {
    public static int minPath = Integer.MAX_VALUE;

    static class Point{
        int x;
        int y;
        boolean visited;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
            this.visited = false;
        }

        public int getLength(Point p){
            int xLength = Math.abs(p.x - this.x);
            int yLength = Math.abs(p.y - this.y);
            return xLength + yLength;
        }
    }

    public static int function(Point from ,Point[] points,int sum ,int count){
        for (int i = 0; i < points.length ; i++) {
            if (!points[i].visited){
                points[i].visited = true;
                count ++;
                sum += from.getLength(points[i]);
                if (count == points.length){
                    sum += points[i].getLength(from);
                    if (sum < minPath){
                        minPath = sum;
                    }
                }
                function(points[i],points,sum,count);
                points[i].visited = false;
                count--;
                sum -= from.getLength(points[i]);
            }
        }
        return minPath;
    }

    public static int function2(Point[] points ,int n){
        if (n == points.length){
            int sum = points[0].getLength(new Point(0,0));
            for (int i = 1;i < points.length;i++){
                sum += points[i].getLength(points[i-1]);
            }
            sum += points[points.length -1].getLength(new Point(0,0));
            minPath = sum > minPath?minPath:sum;
        }

        for (int i = n; i < points.length; i++) {
            swap(points,i,n);
            function2(points,i+1);
            swap(points,n,i);
        }
        return minPath;

    }

    private static void swap(Point[] points,int i, int j){
        if (i ==  j)return;
        Point temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public static void main(String[] args) {
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        num = Integer.parseInt(scanner.nextLine().trim());
        Point[] points = new Point[num];
        for (int i = 0; i <num ; i++) {
            String[] locations = scanner.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
        int res = function(new Point(0,0),points,0,0);
        System.out.println(res);
    }
}
