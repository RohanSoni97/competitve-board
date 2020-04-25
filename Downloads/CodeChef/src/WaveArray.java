import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WaveArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        args=br.readLine().split(" ");
        List<Integer> list=new ArrayList<>();

        for (int i=0;i<N;i++)
            list.add(Integer.parseInt(args[i]));
        Collections.sort(list);
        List<Integer> list1=new ArrayList<>();
        for (int i=0;i<N;i++){
            if((i+1)%2==0) {

                list1.add(list.get(i - 1));
            }
            else {
                if((i+1)<N)
                   list1.add(list.get(i+1));
                else list1.add(list.get(i));
            }
        }
        printArrayList(list1);
    }
    public static void printArrayList(List<Integer> li){
        for (Integer l:li)
            System.out.print(l+" ");
    }
}
