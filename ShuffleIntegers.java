import java.util.*;
class ShuffleIntegers{
    public static void shuffle(long[] arr, int n){
        int i = 1;
        int j = n/2;
        while(i < n - 1 && j < n){
            long temp = arr[j];
            for(int k = j; k > i; --k){
                arr[k] = arr[k - 1];
            }
            arr[i] = temp;
            i = i + 2;
            j++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLong();
        }
        shuffle(arr, n);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}