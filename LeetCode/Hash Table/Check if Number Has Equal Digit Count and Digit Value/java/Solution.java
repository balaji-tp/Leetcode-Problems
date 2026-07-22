class Solution {
    public boolean digitCount(String num) {
        int n = num.length();
        int[] count = new int[10];  
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            count[digit]++;
        }
        for (int i = 0; i < n; i++) {
            int expected = num.charAt(i) - '0';
            if (count[i] != expected) {
                return false;
            }
        }
        return true;
    }
}
