import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List<Pair> list=new ArrayList<>();
        list.add(null);
        for(Pair p:list)
            System.out.println(p);

    }
}
