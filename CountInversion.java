import java.util.*;
class CountInversion{
    public static long inverionsCount(long[] arr, int n){
        return mergeSort(arr, 0, n - 1);
    }
    public static long mergeSort(long[] arr, int l, int r){
        long count = 0;
        if(l < r){
            int m = l + (r - l) / 2;

            count += mergeSort(arr, l, m);
            count += mergeSort(arr, m + 1, r);

            count += merge(arr, l, m, r);
        }
        return count;
    }
    public static long merge(long[] arr, int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        long[] L = new long[n1];
        long[] R = new long[n2];

        for(int i = 0; i < n1; i++){
            L[i] = arr[l + i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[m + 1 +j];
        }
        int i = 0;
        int j = 0;
        int k = l;
        long count = 0;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                count += (n1 - i);
                j++;
            }
        }
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLong();
        }
        long res = inverionsCount(arr, n);
        System.out.println(res);
    }
}