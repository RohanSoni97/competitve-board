import java.util.List;

public class Solution1 {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {

        int n = A.size();

        if(n == 0) return 0;

        int [] dp = new int[n];
        dp[0] = 1;
        int maxLen = 1;

        for(int i=1; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(A.get(i) > A.get(j)){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }

        return maxLen;

    }
}
