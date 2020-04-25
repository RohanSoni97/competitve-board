import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Mice {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        args=br.readLine().split(" ");
        List<Integer> A=new ArrayList<>();
        List<Integer> B=new ArrayList<>();
        for(int i=0;i<3;i++)
            A.add(Integer.parseInt(args[i]));
        args=br.readLine().split(" ");
        for(int i=0;i<3;i++)
            B.add(Integer.parseInt(args[i]));
        int result=filltheMice(A,B);
        System.out.println(result);
    }

    private static int filltheMice(List<Integer> a, List<Integer> b) {
        Collections.sort(a);Collections.sort(b);
        int min=0;
        for (int i=0;i<a.size();i++)
        {
           int result= b.get(i)-a.get(i);
           if(result>min)
               min=result;
        }
        return min;
    }
}
