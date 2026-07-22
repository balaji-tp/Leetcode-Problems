class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int len = stack.length();
            if (len > 0 && stack.charAt(len - 1) == c) {
                stack.deleteCharAt(len - 1);  // Remove the duplicate
            } else {
                stack.append(c);  // Push the current char
            }
        }
        
        return stack.toString();
    }
}
