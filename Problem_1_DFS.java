/*
 * Time Complexity : O(m*n)
 * Space Complexity : O(m*n) --> if we consider the internal stack space
 * 
 */
public class Problem_1_DFS {
	
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[sr][sc] == newColor){
            return image;
        }
        int srcColor = image[sr][sc];
       
        image[sr][sc] = newColor;
        dfs(image, sr, sc, srcColor, newColor);
        
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int srcColor, int newColor){
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        for(int[] dir : dirs){
            
            int row = sr + dir[0];
            int col = sc + dir[1];
            
            if(row >= 0 && row < image.length && col >= 0 && col < image[0].length && image[row]                     [col] == srcColor){
                image[row][col] = newColor;
                
                dfs(image, row, col, srcColor, newColor);
            }        
        }  
    }

}
