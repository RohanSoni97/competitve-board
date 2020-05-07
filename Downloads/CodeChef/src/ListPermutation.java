import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ListPermutation {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);list.add(1);list.add(2);
        ListPermutation p=new ListPermutation();
       List<int[]> l= p.permute(list);
       for(int [] a:l){
           for(int i=0;i<a.length;i++)
               System.out.print(a[i]+" ");
       }

    }

    private List<int[]> permute(List<Integer> list) {
        Map<Integer,Integer> countMap=new TreeMap<>();
        for(Integer i:list) {
            countMap.compute(i, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }
        int num[]=new int[countMap.size()];
        int count[]=new int[countMap.size()];
        int index=0;
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()) {
            num[index]=entry.getKey();
            count[index]=entry.getValue();
            index++;
        }
        List<int[]> resultList=new ArrayList<>();
        int result[]=new int[list.size()];
        permuteUtil(num, count, result, 0, resultList);
        return resultList;
    }

    private void permuteUtil(int[] num, int[] count, int[] result, int l, List<int[]> resultList) {
        if (l == result.length) {
            int temp[]=new int[l];
            temp=result;
            resultList.add(temp);
            return;
        }

        for(int i = 0; i < num.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[l]=num[i];
            count[i]--;
            permuteUtil(num, count, result, l + 1, resultList);
            count[i]++;
        }
    }
}
/*


public class Solution {

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
}


 */
