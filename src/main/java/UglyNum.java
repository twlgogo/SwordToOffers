/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/10
 * Time: 下午8:24
 */
public class UglyNum {

    public static int getIthUglyNum(int i){
    if (i <= 0)return 0;
    int[] uglyNums = new int[i];
    int generatedBy2 = 0 ;
    int generatedBy3 = 0 ;
    int generatedBy5 = 0 ;
    uglyNums[0] = 1;
    for (int j = 1; j < i; j++) {
      int next = min(uglyNums[generatedBy2]*2,uglyNums[generatedBy3]*3,uglyNums[generatedBy5]*5);
      uglyNums[j] = next;
       while (uglyNums[generatedBy2]*2 <= next)generatedBy2++;
       while (uglyNums[generatedBy3]*3 <= next)generatedBy3++;
       while (uglyNums[generatedBy5]*5 <= next)generatedBy5++;
    }
    return uglyNums[i-1];
  }

  public static int getUglyNumber(int index) {
    if (index <= 0) {
      return 0;
    }

    int num = 0;
    int uglyFound = 0;
    while (uglyFound < index) {
      num++;
      if (isUgly(num)) {
        ++uglyFound;
      }
    }

    return num;
  }

  private static boolean isUgly(int num) {
    while (num % 2 == 0) {
      num /= 2;
    }

    while (num % 3 == 0) {
      num /= 3;
    }

    while (num % 5 == 0) {
      num /= 5;
    }

    return num == 1;
  }




  private static int min(int num1, int num2, int num3){
    int min = num1 < num2 ? num1 : num2;
    return min < num3 ? min : num3;
  }

  public static void main(String[] args) {

    long p1 = System.currentTimeMillis();
    System.out.println(getIthUglyNum(1500));
    System.out.println(System.currentTimeMillis() - p1);

    p1 = System.currentTimeMillis();
    System.out.println(getUglyNumber(1500));
    System.out.println(System.currentTimeMillis() - p1);

  }
}
