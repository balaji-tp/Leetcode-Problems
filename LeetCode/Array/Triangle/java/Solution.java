class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int down = triangle.get(i + 1).get(j);
                int downRight = triangle.get(i + 1).get(j + 1);
                int newVal = triangle.get(i).get(j) + Math.min(down, downRight);
                triangle.get(i).set(j, newVal);
            }
        }
        return triangle.get(0).get(0);
    }
}
