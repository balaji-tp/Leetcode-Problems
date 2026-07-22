class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
         int initialColor=image[sr][sc];
        int[][]arr=Arrays.copyOf(image,image.length);
        int[]allowedToGoRow={0,-1,1,0};
        int[]allowedToGoCol={-1,0,0,1};
        helperDfs(arr,sr,sc,color,initialColor,allowedToGoRow,allowedToGoCol);
        return arr;
    }
    public static void helperDfs(int[][]arr,int row,int col,int newColor,int initialColor,int[]allowedToGoRow,int[]allowedToGoCol){
        arr[row][col]=newColor;
        for(int i=0;i<4;i++){
            int newRow=row+allowedToGoRow[i];
            int newCol=col+allowedToGoCol[i];
            if(newRow>=0&&newRow<arr.length&&newCol>=0&&newCol<arr[0].length&&arr[newRow][newCol]!=newColor&&arr[newRow][newCol]==initialColor){
                helperDfs(arr,newRow,newCol,newColor,initialColor,allowedToGoRow,allowedToGoCol);
            }
        }
    }
}