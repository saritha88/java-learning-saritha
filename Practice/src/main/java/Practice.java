public class Practice {

    public static void main(String[] args) {
        int arr[] = new int[6];
        for(int i=0;i<arr.length;i++){
            arr[i]=i+1;
            System.out.println(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
           for(int j=0;j<arr.length;j++) {
               System.out.println(arr[i]+arr[j]);
           }
        }
    }
}
