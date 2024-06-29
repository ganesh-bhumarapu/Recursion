import java.util.*;
class SubsetSums{
    public static ArrayList<Integer> subsetSum(ArrayList<Integer> arr, int n){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        solve(0, 0, arr, n, ans);
        Collections.sort(ans);
        return ans;
    }
    public static void solve(int index, int sum, ArrayList<Integer> arr, int n, ArrayList<Integer> ans){
        if(index == n){
            ans.add(sum);
            return;
        }
        solve(index + 1, sum + arr.get(index), arr, n, ans);

        solve(index + 1, sum, arr, n, ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            arr.add(sc.nextInt());
        }
        ArrayList<Integer> res = subsetSum(arr, n);
        for(int sum : res){
            System.out.println(sum);
        }
    }
}