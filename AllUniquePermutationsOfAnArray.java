import java.util.*;
public class AllUniquePermutationsOfAnArray{
    public static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        boolean[] frequency = new boolean[n];
        Collections.sort(arr);
        uniquePermsHelper(arr, n, ds, ans, frequency);
        return ans;
    }
    public static void uniquePermsHelper(ArrayList<Integer> arr, int n, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ans, boolean[] frequency){
        if(ds.size() == n){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0; i < n; i++){
            if(i > 0 && arr.get(i).equals(arr.get(i - 1)) && !frequency[i - 1]){
                continue;
            }
            if(!frequency[i]){
                frequency[i] = true;
                ds.add(arr.get(i));
                uniquePermsHelper(arr, n, ds, ans, frequency);
                ds.remove(ds.size() - 1);
                frequency[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(sc.nextInt());
        }
        ArrayList<ArrayList<Integer>> result = uniquePerms(arr, n);
        for(ArrayList<Integer> element: result){
            System.out.println(element);
        }
    }
}