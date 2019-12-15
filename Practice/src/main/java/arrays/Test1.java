package arrays;
//print array in reverse
public class Test1 {

    public static void main(String[] args) {
      int arr[] = {4,6,8,2,3};
      for(int i = arr.length-1;i >= 0;i--){
          System.out.println(arr[i]);
      }
    }
}
