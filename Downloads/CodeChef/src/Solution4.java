import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    private ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        combination(A,0);
        return answer;
    }

    private void combination(  ArrayList<Integer> A, int n ){
        //System.out.println(A);
        if( n >= A.size() ){
            return ;
        }

        if( n == A.size()-1 ){
            ArrayList<Integer> ans = new ArrayList<>(A);
            if( !answer.contains(ans) ){
                answer.add(ans);
            }
        }

        for( int i = n ; i < A.size(); i++ ) {
            swap(n,i,A);
            combination(A,n+1);
            swap(n,i,A);
        }
    }

    private void swap( int i, int j, ArrayList<Integer> A ){
        int temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        Solution4 s=new Solution4();
        s.permute(list);
    }

}

