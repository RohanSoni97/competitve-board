import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

class In{
    Integer start;

    public In(Integer start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return this.start.toString();
    }
}
//[1,3],[2,6],[8,10],[15,18]
public class Demo {
    public static void main(String[] args) {

        TreeMap<In,Integer> hm=new TreeMap<>();
        ArrayList<ArrayList<Integer>> finalList=new ArrayList<>();
        ArrayList<Integer> integerArrayList=new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(3);
        finalList.add(integerArrayList);
        integerArrayList=new ArrayList<>();
        integerArrayList.add(2);
        integerArrayList.add(6);
        finalList.add(integerArrayList);
        integerArrayList=new ArrayList<>();
        integerArrayList.add(8);
        integerArrayList.add(10);
        finalList.add(integerArrayList);
        integerArrayList=new ArrayList<>();
        integerArrayList.add(15);
        integerArrayList.add(18);
        finalList.add(integerArrayList);
        integerArrayList=new ArrayList<>();
        integerArrayList.add(2);
        integerArrayList.add(3);
        finalList.add(integerArrayList);


        for (ArrayList<Integer> ol: finalList)
        {
           hm.put(new In(ol.get(0)), ol.get(1));
        }
        System.out.println(hm.keySet());

    }
}
