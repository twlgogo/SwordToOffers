/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/16
 * Time: 下午11:28
 */
public class T56FindNumAppearOnce {
  public static void function(int[] data, int[] left, int[] right) {
    if (data == null || data.length == 0) return;
    int resultXOR = 0 ;
    for (int i = 0; i < data.length ; i++) {
      resultXOR = resultXOR^data[i];
    }
    int indexOf1 = findIndexOf1(resultXOR);
    for (int i = 0; i < data.length; i++) {
      if (isBitOne(data[i] , indexOf1)) {
        left[0] ^= data[i];
      }else {
        right[0] ^=data[i];
      }
    }
  }

  private static int findIndexOf1(int resultXOR) {
    int res = 0;
    while ((resultXOR & 1) == 0 && res < 32) {
      res ++ ;
      resultXOR = resultXOR >>1;
    }
    return res;
  }

  private static boolean isBitOne (int num, int index) {
    num = num >> index;
    return (num & 1) == 1;
  }

  public static void main(String[] args) {
    int []data = {2,4,3,6,3,2,5,5};
    int[] left = new int[1];
    int[] right = new int[1 ];

    function(data,left,right);
    System.out.println(left[0]+" "+ right[0]);
  }
}
