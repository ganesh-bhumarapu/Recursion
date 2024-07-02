import java.util.*;
class PermutationsOfAGivenString{
    public static List<String> find_permutation(String S){
        List<List<Character>> ans = new ArrayList<>();
        List<Character> ds = new ArrayList<>();
        boolean[] frequency = new boolean[S.length()];
        List<Character> chars = new ArrayList<>();
        for(char c : S.toCharArray()){
            chars.add(c);
        }
        Collections.sort(chars);
        permutationHelper(chars, ds, ans, frequency);
        List<String> flatList = new ArrayList<>();
            for(List<Character> list : ans){
                StringBuilder sb = new StringBuilder();
                for(Character ch : list){
                    sb.append(ch);
                }
                flatList.add(sb.toString());
        }
        return flatList;
    }
    public static void permutationHelper(List<Character> chars, List<Character> ds, List<List<Character>> ans, boolean[] frequency) {
        if (ds.size() == chars.size()) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < chars.size(); i++) {
            if (i > 0 && chars.get(i) == chars.get(i - 1) && !frequency[i - 1]) {
                continue;
            }
            if (!frequency[i]) {
                frequency[i] = true;
                ds.add(chars.get(i));
                permutationHelper(chars, ds, ans, frequency);
                ds.remove(ds.size() - 1);
                frequency[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        System.out.println(find_permutation(S));
    }
}