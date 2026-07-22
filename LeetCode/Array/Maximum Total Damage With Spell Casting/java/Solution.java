import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
      
        Map<Long, Long> damageMap = new HashMap<>();
        for (int p : power) {
            damageMap.put((long) p, damageMap.getOrDefault((long) p, 0L) + p);
        }

        List<Long> keys = new ArrayList<>(damageMap.keySet());
        Collections.sort(keys);

        int n = keys.size();
        long[] dp = new long[n];

        
        dp[0] = damageMap.get(keys.get(0));

        for (int i = 1; i < n; i++) {
            long currKey = keys.get(i);
            long currDamage = damageMap.get(currKey);

            
            int prevIndex = i - 1;
            while (prevIndex >= 0 && currKey - keys.get(prevIndex) <= 2) {
                prevIndex--;
            }

            long pick = currDamage + (prevIndex >= 0 ? dp[prevIndex] : 0);
            long skip = dp[i - 1];
            dp[i] = Math.max(skip, pick);
        }

        return dp[n - 1];
    }
}
