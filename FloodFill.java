/*
    BFS approach

    we will maintain the queue for BFS traversal we will add row and col of the current element in queue
    we will put all the neighbour nodes of starting node intothe queue for subsequenet processing
    but before putting into the queue we will change it with new color. we will change the color to the new color for
    every neighbour having color equals to starting location

    Time Complexity :  O(N)


    Space Complexity : O(N)

    is worked on leetcode : YES

    
*/



public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if( image == null || image.length == 0 || image[sr][sc] ==  newColor) return image;
        int color = image[sr][sc];
        Queue<int[]> queue = new LinkedList();
        int r_count = image.length;
        int c_count = image[0].length;
        image[sr][sc] = newColor;
        queue.add(new int[]{sr,sc});
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    
        while(!queue.isEmpty()){
            int size = queue.size();
           
                int[]m = queue.poll();
                for(int[] dir : dirs){
                    int r = m[0] +  dir[0];
                    int c = m[1] +  dir[1];
                    if( r >= 0 && r < r_count && c >= 0  && c < c_count && image[r][c] == color ){
                        image[r][c] = newColor;  
                        queue.add(new int[]{r,c});
                    }     
                }  
            
        }
        
        return image;
    }
}

/*

    class Solution {
    int color;
    int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if( image == null || image.length == 0 || image[sr][sc] ==  newColor) return image;
        color = image[sr][sc];
        // image[sr][sc] = newColor;
        dfs(image, sr,sc, newColor);
        return image;
        
        
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor){
        
        
        if( sr >=0 && sr < image.length && sc >=0 && sc< image[0].length && image[sr][sc] == color){
            image[sr][sc] = newColor;
            
            for(int [] dir : dirs){
                dfs(image, sr+ dir[0] , sc+dir[1],newColor);
            }
        }
        
    }
}


*/