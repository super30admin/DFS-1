// Time Complexity : O(mn) in worst case if all nodes are connected and need to be updated 
// Space Complexity : O(mn) since this is dfs, in worst case we could assume all nodes are in the call stack with pending calls to visit other neighbours 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// do a dfs from the source node, updateColor, if neighbour has pixel value==sourceColor then call dfs on that neighbour

class Solution {
    int[][] image; 
    int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    int sourceColor;
    int newColor;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor) return image;
        
        this.image = image;
        this.sourceColor = image[sr][sc];
        this.newColor = newColor;
        dfs(sr, sc);
        
        return image;
    }
    
    private void dfs(int row, int col){
        image[row][col] = newColor;
        for(int[] dir : dirs){
            int r = row+dir[0];
            int c = col+dir[1];
            
            if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]==sourceColor){
                dfs(r, c);
            }
        }
    }
}


// Time Complexity : O(mn) worst case need to visit all nodes 
// Space Complexity : O(mn), this would be the items in the queue, worst case of the order of O(mn) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// this would be the bfs version of the solution
class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor) return image;
        
        int sourceColor = image[sr][sc];
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{sr, sc});
        
        while(!q.isEmpty()){
            int[] node = q.poll();
            image[node[0]][node[1]] = newColor;
            
            for(int[] dir : dirs){
                int r = node[0] + dir[0];
                int c = node[1] + dir[1];
                
                if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]==sourceColor){
                    q.add(new int[]{r, c});
                }
            }
        }
    
        return image;
    }
}