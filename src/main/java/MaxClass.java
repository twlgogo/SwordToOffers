import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;


public class MaxClass {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine().trim());
    int m = Integer.parseInt(scanner.nextLine().trim());
    int []end = new int[n];
    int []dup = new int[n];
    int []start = new int[n];
    Map<Integer,Integer> map1 = new HashMap<>();
    String []str = scanner.nextLine().trim().split(" ");
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      end[i] = Integer.parseInt(str[2*i+1]);
      start[i] = Integer.parseInt(str[2*i]);
      if (end[i] < start[i]) end[i] += m;
      dup[i] = end[i] - Integer.parseInt(str[2*i]);
      map1.put(end[i],dup[i]);
      priorityQueue.offer(end[i]);
    }
    int lastEnd = 0 ,size = 0;
    for (int i = 0; i < n; i++) {
      int now = priorityQueue.poll();
      int begin = now - map1.get(now);
      if (begin >= lastEnd){
        size++;
        lastEnd = now;
      }
    }
    System.out.println(size);
  }
}
