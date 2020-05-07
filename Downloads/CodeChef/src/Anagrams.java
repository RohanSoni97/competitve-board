import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        HashMap<String,ArrayList<Integer>> hashMap=new HashMap<>();
                ArrayList<ArrayList<Integer>> finalArrayList=new ArrayList<>();
                ArrayList<Integer> innerArrayList=null;
                int size=A.size();
                if(size==1)
                {
                    innerArrayList=new ArrayList<>();
                    innerArrayList.add(1);
                    finalArrayList.add(innerArrayList);
                    return finalArrayList;
                }
                for(int i=0;i<size;i++)
                {
                    char tempArray[] = A.get(i).toCharArray();
                    Arrays.sort(tempArray);
                    String s=new String(tempArray);
                    if(hashMap.containsKey(s)){
                innerArrayList=hashMap.get(s);

                innerArrayList.add(i+1);

            }
            else {
                innerArrayList=new ArrayList<>();
                innerArrayList.add(i+1);
                finalArrayList.add(innerArrayList);
                hashMap.put(s,innerArrayList);
            }

        }
        return finalArrayList;
    }
    public static void main(String[] args) {
    List<String> list=new ArrayList<>();
    list.add("caat");
    list.add("taac");
    list.add("god");
    list.add("dog");
        list.add("acta");
    /*
     "caat", "taac", "dog", "god", "acta"
     */
    Anagrams a=new Anagrams();
    ;
        System.out.println(a.anagrams(list));
    }
}
