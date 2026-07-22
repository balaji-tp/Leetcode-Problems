class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";

        StringBuilder str = new StringBuilder();
        boolean neg = false;

        if (num < 0) neg = true;
        num = Math.abs(num);

        while (num > 0) {
            str.append(num % 7);
            num = num / 7;
        }

        if (neg) str.append("-");
        return str.reverse().toString();
    }
}