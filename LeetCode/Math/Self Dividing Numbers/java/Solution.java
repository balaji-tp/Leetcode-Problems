class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)){
                ans.add(i);
            }
        }
        return ans;
    }

    static boolean isSelfDividingNumber(int original) {
        int num = original;
        while (num != 0) {
            int digit = num % 10;
            if (digit == 0 || original % digit != 0)
                return false;
            num /= 10;
        }
        return true;
    }
}