/*
1 -> sort the given arraylist
2 -> create  uniqueList
3 -> call for combinationHelper
b -> sum element
 */

import java.util.*;
class CombinationSum {
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(A);
        ArrayList<Integer> uniqueList = new ArrayList<>();
        for(int num : A){
            if(uniqueList.isEmpty() || !uniqueList.get(uniqueList.size() - 1).equals(num)){
                uniqueList.add(num);
            }
        }
        combinationHelper(0, uniqueList, B, ans, new ArrayList<>());
        return ans;
    }
    public static void combinationHelper(int index, ArrayList<Integer> A, int B, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> res){
        if(B == 0){
            ans.add(new ArrayList<>(res));
            return;
        }
        if(B < 0 || index == A.size()){
            return;
        }
        res.add(A.get(index));
        combinationHelper(index, A, B - A.get(index), ans, res);
        res.remove(res.size() - 1);
        combinationHelper(index + 1, A, B, ans, res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for(int i = 0; i < n; i++){
            A.add(sc.nextInt());
        }
        int B = sc.nextInt();

        ArrayList<ArrayList<Integer>> result = combinationSum(A, B);

        for(ArrayList<Integer> combinations : result){
            System.out.println(combinations);
        }
    }
}