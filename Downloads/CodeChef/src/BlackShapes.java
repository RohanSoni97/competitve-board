import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BlackShapes {
    static int dirc [][] = { {0 , 1}, {0 , -1}, {1 , 0} };
   static boolean vis [][]=new boolean[1010][1010];
    public static void main(String[] args) throws IOException {
        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> input=new ArrayList<>();
        args=b.readLine().split(" ");
        int N=Integer.parseInt(args[0]);
        int M=Integer.parseInt(args[1]);
        for (int i=0;i<N;i++)
        input.add(b.readLine());
       int result= black(input);
    }

    private static int black(ArrayList<String> input) {
        int N=input.size();
        int M=input.get(0).length();
        int count=0;
        for (int i=0;i<N;i++)
        {
            for (int j=0;j<M;j++)
            {
                if(  input.get(i).charAt(j)=='X' && !vis[i][j])
                {
                    dfs(i,j,vis,N,M,input);
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    private static void dfs(int i, int j, boolean[][] vis, int n, int m, ArrayList<String> input) {

        vis[i][j] = true;
        for (int k=0;k<3;k++){
            int dx = i + dirc[k][0];                    // transition
            int dy = j + dirc[k][1];

            if(dx < 0 || dx >= n || dy < 0|| dy >= m) continue;
            if(input.get(dx).charAt(dy) == 'X' && !vis[dx][dy])
                 dfs(dx, dy, vis,n,m,input);
        }
        return;

    }

}
