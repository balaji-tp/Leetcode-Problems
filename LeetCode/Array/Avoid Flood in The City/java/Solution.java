import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1; // temporary placeholder (any lake can be dried)
            } else {
                int lake = rains[i];
                ans[i] = -1; // raining day

                if (fullLakes.containsKey(lake)) {
                    // Need a dry day after the last time it was filled
                    Integer dryDay = dryDays.higher(fullLakes.get(lake));
                    if (dryDay == null) {
                        return new int[0]; // no valid dry day → flood
                    }
                    ans[dryDay] = lake; // dry this lake on that day
                    dryDays.remove(dryDay);
                }
                fullLakes.put(lake, i);
            }
        }
        return ans;
    }
}
