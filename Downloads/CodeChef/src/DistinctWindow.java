import java.util.ArrayList;
import java.util.HashMap;

public class DistinctWindow {
    static HashMap<Integer,Integer> map=new HashMap<>();
    public static void main(String[] args) {
        int n=0,k=3,count=0;
        int ar1[]={1, 2, 1, 3, 4, 3};
        n=ar1.length;
        ArrayList<Integer> ar=new ArrayList<>();
        for (int i=0;i<n;i++)
        {
            ar.add(ar1[i]);
        }

        ArrayList<Integer> list=new ArrayList<>();
        for(int l=0;l<k;l++)
        {
            if(map.containsKey(ar.get(l)))
            {
                map.put(ar.get(l),map.get(ar.get(l))+1);
            }
            else {
                count++;
                map.put(ar.get(l),1);
            }
        }
        list.add(count);
        for (int i = 1; i < n - k+1; i++) {
                int j=i+k-1;

                if(map.get(ar.get(i-1))==1) {

                    map.remove(ar.get(i-1));
                    count--;
                }
                else {
                    map.put(ar.get(i-1), map.get(ar.get(i-1)) - 1);
                }
                if(map.containsKey(ar.get(j))){
                   map.put(ar.get(j),map.get(ar.get(j))+1);
                }
                else {
                    count++;
                    map.put(ar.get(j),1);
                }
                list.add(count);
        }
        System.out.println(list);
        }
}
