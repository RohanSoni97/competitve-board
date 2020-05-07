import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Duplicates {
    public static int repeatedNumber(final List<Integer> A) {
        int n=A.size();
        HashMap<Integer,Integer> map=new HashMap<>();
        int no=0,temp;
        for(int i=0;i<n/2;i++)
        {
            if(map.containsKey(temp=A.get(i)) && map.get(temp)!=i)
            {
              no=temp;
              break;
            }
            map.put(temp,i);
            if(map.containsKey(temp=A.get(n-i-1)) && map.get(temp)!=n-i-1)
            {
                no=temp;
                break;
            }
            map.put(temp,n-i-1);

        }
        return no;
    }

    public static void main(String[] args) {
        final List<Integer> l=new ArrayList<>();
        l.add(1);
        l.add(1);
        ;
        System.out.println(repeatedNumber(l));
    }
}
