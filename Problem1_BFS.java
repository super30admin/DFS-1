/**
LeetCode Submitted : YES
Time Complexity : O(N)
Space Complexity : O(N)

The idea is to fill the pixel with newColor from Original by traversing in BFS fashion. Here, we are creating  a Queue to store the pixel where we have changed the color and then traverse in horizontal and vertical direction.
**/


class Solution {
    
    //int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
    //int[][] dirs = {{0,1},{0,-1},{-1,-1},{1,1},{1,0},{-1,0},{-1,1},{1,-1}};
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //int[][] floodFillStatus = new int[image.length][image[0].length];  
        if(image == null || image.length < 1 || image[sr][sc] == newColor)
              return image;
        
        Queue<int[]> q = new LinkedList<>();
        
        int orgColor = image[sr][sc];
        
        //Add sr and sc to the Queue
        q.add(new int[]{sr,sc});
        image[sr][sc] = newColor;
        
        while(!q.isEmpty()){
            int[] node = q.poll();
            
            for(int[] dir : dirs){
                int newRow = node[0] + dir[0];
                int newCol = node[1] + dir[1];
                if(newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length && image[newRow][newCol] == orgColor){ 
                    image[newRow][newCol] = newColor;
                    q.add(new int[]{newRow,newCol});
                }
            }        
        }
        return image;
          
    }
    
    /*public void fill (int[][] image, int sr, int sc,int orgColor, int newColor){//,int[][] floodFillStatus){
        
        for(int[] dir : dirs){
            int newRow = sr + dir[0];
            int newCol = sc + dir[1];
            if(newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length && image[newRow][newCol] == orgColor){ //&& floodFillStatus[newRow][newCol] == 0 ){
                image[newRow][newCol] = newColor;
                //floodF=llStatus[newRow][newCol] = 1;
                fill(image,newRow,newCol,orgColor,newColor);//,floodFillStatus);
            }
        }
    }*/
}
