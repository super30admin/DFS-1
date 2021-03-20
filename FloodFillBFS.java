// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[0].length == 0){
            return image;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        //last testcase [[0,0,0],[0,1,1]],1,1,1 
        //since infinite loop for if the newColor is not checked to the original array.
        if(newColor==image[sr][sc]){
            return image;
        }
        
        int rows=image.length;
        int cols=image[0].length;
        
        queue.add(new int[]{sr, sc});
        int source = image[sr][sc];
        image[sr][sc] = newColor;
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                int[] front = queue.poll();
                
                for(int[] dir:dirs){
                    int j = dir[0]+front[0];
                    int k=dir[1]+front[1];
                    
                    if(j<rows && j>=0 && k<cols && k>=0 && image[j][k] == source){
                        image[j][k] = newColor;
                        queue.add(new int[]{j,k});
                    }
                }
            }
        }
        return image;
    }
}
