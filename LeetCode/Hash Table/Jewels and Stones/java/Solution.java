import java.util.*;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // Store all jewels in a HashSet for quick lookup
        Set<Character> jewelSet = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }

        int count = 0;
        // Count stones that are jewels
        for (char c : stones.toCharArray()) {
            if (jewelSet.contains(c)) {
                count++;
            }
        }

        return count;
    }
}
