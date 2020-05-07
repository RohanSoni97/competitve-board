import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {


            public static int removeDuplicates(final ArrayList<Integer> a) {
                int i = 0;
                for (int j = 1; j < a.size(); j++)
                    if (!a.get(i).equals(a.get(j)))
                        a.set(++i, a.get(j));
                while (a.size() > i + 1)
                    a.remove(a.size() - 1);
                return a.size();
            }


    public static void main(String[] args) {
        ArrayList<Integer> a=new ArrayList<>();
      int ar[]={0, 0, 0, 1, 1, 2, 2, 3};

        a.add(0);
        a.add(0);
        a.add(0);
        a.add(1);a.add(1);
        a.add(2);a.add(2);a.add(3);

        removeDuplicates(a);

    }
}
