import java.util.*;
class subset2{
    public static ArrayList<ArrayList<Integer>> subset(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(0, new ArrayList<>(), nums, n, ans);
        return ans;
    }
    public static void solve(int index, ArrayList<Integer> res, int[] nums, int n, ArrayList<ArrayList<Integer>> ans){
        ans.add(new ArrayList<>(res));
        for(int i = index; i < n; i++){
            if( i > index && nums[i] == nums[i-1]) continue;

            res.add(nums[i]);

            solve(i + 1, res, nums, n, ans);

            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> result = subset(nums);
        for(ArrayList<Integer> subset : result ){
            System.out.println(subset);
        }
    }
}