import java.util.ArrayList;
import java.util.List;

public class MaxProduct {
    public static void main(String[] args) {
        int ar[] = { 2, 3, -2, 4};
        List<Integer> list = new ArrayList<>();
        list.add(2);list.add(3);list.add(-2);list.add(4);
        int n=optimalSearchTree(list);
        System.out.println(n);
    }

    private static int optimalSearchTree(List<Integer> ar) {
        int n=ar.size();
        int cost[][]=new int[n+1][n+1];
        int max=Integer.MIN_VALUE;
        for (int i=0;i<n;i++)
        {
            if(ar.get(i)>max)
            {
                max=ar.get(i);
            }
            cost[i][i]=ar.get(i);
        }
        for (int L=2;L<=n;L++)
        {
            for (int i=0;i<= n-L+1;i++)
            {
                int j=i+L-1;
                cost[i][j]=cost[i][j-1]* cost[j][j];
                if(cost[i][j]>max)
                    max=cost[i][j];
            }
        }
        return max;
    }
}
