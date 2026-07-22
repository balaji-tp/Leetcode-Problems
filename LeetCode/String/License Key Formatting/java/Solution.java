class Solution {
    public String licenseKeyFormatting(String s, int k) {
        boolean b = true;
        StringBuilder p = new StringBuilder(s);
        StringBuilder ans = new StringBuilder();
        int c = 0;
        p.reverse();
        String l = p.toString();
        for (char i : l.toCharArray()) {
                if (i != '-') {
                    if (c == k) {
                        c = 0;
                        ans.append('-');
                    }
                    ans.append(Character.toUpperCase(i));
                    c += 1;
                }
            }
        ans.reverse();
        return ans.toString();
    }
}