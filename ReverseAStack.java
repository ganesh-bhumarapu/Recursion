import java.util.*;
class ReverseAStack{
    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()) return;

        int ele = s.pop();
        reverse(s);
        insertAtBottom(s, ele);
    }
    public static void insertAtBottom(Stack<Integer> s, int ele){
        if(s.isEmpty()){
            s.add(ele);
            return;
        }
        int temp = s.pop();
        insertAtBottom(s, ele);
        s.push(temp);
    }
//    static void reverse(Stack<Integer> s)
//    {
//        // add your code here
//        ArrayList<Integer> ans = new ArrayList<>();
//        while(!s.isEmpty()){
//            ans.add(s.pop());
//        }
//
//        for(int i = 0; i < ans.size(); i++){
//            s.add(ans.get(i));
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        System.out.println("Enter the number of elements in the stack:");
        int n = sc.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            s.push(sc.nextInt());
        }

        System.out.println("Original stack: " + s);
        reverse(s);
        System.out.println("Reversed stack: " + s);
    }
}