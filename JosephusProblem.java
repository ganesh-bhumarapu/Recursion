import java.util.*;
class JosephusProblem{
    public static int josephus(int n, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            ans.add(i);
        }
        return josephusHelper(ans, k, 0);
    }
    public static int josephusHelper(ArrayList<Integer> ans, int k, int index){
        if(ans.size() == 0){
            return ans.get(0);
        }
        index = (index + k - 1) % ans.size();
        ans.remove(index);
        return josephusHelper(ans, k, index);
    }
//    public int josephus(int n, int k)
//    {
//        if(n==1)
//            return 1;
//        else
//            return (josephus(n-1,k)+k-1)%n+1;
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(josephus(n, k));
    }
}