/**
LeetCode Submitted : YES
Time Complexity : O(N)
Space Complexity : O(1)

The idea is to fill the pixel with newColor from Original by traversing in DFS fashion. Here, we are creating the backup of the original array to keep track of the original color.
**/


class Solution {
    
    //int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
    //int[][] dirs = {{0,1},{0,-1},{-1,-1},{1,1},{1,0},{-1,0},{-1,1},{1,-1}};
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //int[][] floodFillStatus = new int[image.length][image[0].length];  
        if(image == null || image.length < 1 || image[sr][sc] == newColor)
              return image;
        
                
        
            //recursive change the path using helper function
            fill(image,sr,sc,image[sr][sc],newColor);//,floodFillStatus);
            image[sr][sc] = newColor; 
            return image;
            
    }
    
    public void fill (int[][] image, int sr, int sc,int orgColor, int newColor){//,int[][] floodFillStatus){
        
        for(int[] dir : dirs){
            int newRow = sr + dir[0];
            int newCol = sc + dir[1];
            if(newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length && image[newRow][newCol] == orgColor){ //&& floodFillStatus[newRow][newCol] == 0 ){
                image[newRow][newCol] = newColor;
                //floodF=llStatus[newRow][newCol] = 1;
                fill(image,newRow,newCol,orgColor,newColor);//,floodFillStatus);
            }
        }
    }
}
