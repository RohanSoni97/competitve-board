import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MANRECT {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test_case=Integer.parseInt(br.readLine());
        int XL=0,YL=0,XH=1000000000,YH=1000000000;
        int result=0,result1=0;
        for(int i=0;i<test_case;i++)
        {
            System.out.println("Q"+" "+XL+" "+YL);
            result=Integer.parseInt(br.readLine());
            System.out.println("Q"+result+" "+YL);
            result1=Integer.parseInt(br.readLine())-result;
            YL=(result+result1)/2;
            XL=(result-YL);
            System.out.println("Q"+" "+XH+" "+YH);
            result=(XH+YH)-Integer.parseInt(br.readLine());
            System.out.println("Q"+result+" "+YH);
            result1=Integer.parseInt(br.readLine())-result-YH;
            YH=(result+result1)/2;
            XH=(result-YH);
            System.out.println("A"+" "+XL+" "+YL+" "+XH+" "+YH);
        }
    }
}
