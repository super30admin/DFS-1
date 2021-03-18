// Time Complexity :O(n*m)
// Space Complexity :O(n*m)


// Your code here along with comments explaining your approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       if(image.length == 0 || image[0].length == 0 || image == null || image[sr][sc] == newColor)
           return image;
        
        int n = image.length;
        int m = image[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{sr,sc});
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                int[] front = queue.poll();
                
                for(int[] dir : dirs){
                    int j = dir[0] + front[0];
                    int k = dir[1] + front[1];
                    
                    if(j<n && j>=0 && k<m && k>=0 && image[j][k] == oldColor){
                        image[j][k] = newColor;
                        queue.add(new int[]{j,k});
                    }
                }
                
            }
        }
        return image;
    }
}