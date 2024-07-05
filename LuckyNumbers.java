import java.util.*;
class LuckyNumbers{
    public static boolean isLucky(int n){

        return isLuckyHelper(n, 2);
    }
    public static boolean isLuckyHelper(int n, int i){
        if(i > n) {
            return true;
        }
        if(i % n == 0) {
            return false;
        }
        n = n - (n/i);

        return isLuckyHelper(n, i + 1);
    }
    /*
    for(int i = 2; i <= n; i++){
        if(n % i == 0) return false;
        n = n - (n/i);
        }
        return true;
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isLucky(n));
    }
}