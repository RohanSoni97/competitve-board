import java.util.ArrayList;
import java.util.List;

public class Conc {
    static List<Integer> optimalSearchTree(String s,List<String> words)
    {
        List<Integer> list=new ArrayList<>();
        int n=s.length();
        int tot_list=words.size();
        int size=words.get(0).length();
        for (int i = 0; i <= n - size + 1; i++) {
            int j = i + size - 1;
            String temp=s.substring(i,j+1);
            if(words.contains(temp)){
                list.add(i);
                words.remove(temp);
            }
            if(tot_list==list.size())
                break;
        }

            return list;
    }

    public static void main(String[] args) {
        //["foo", "bar"]
        List<String> list=new ArrayList<>();
        list.add("foo");
        list.add("bar");
        String s="barfoothefoobarman";
       ;
        System.out.println(optimalSearchTree(s,list));
    }
}
