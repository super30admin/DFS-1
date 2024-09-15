// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//FLOODFILL
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length ==0 || image[sr][sc] == newColor )
            return image;
        
        dfs(image, sr,sc, image[sr][sc], newColor);
        return image;
    }
    
    private void dfs(int[][] image , int i, int j,int currentColor, int newColor)
    {
        if(i<0 || i>=image.length || j<0 || j>=image[0].length  || image[i][j]!=currentColor)
            return;
        
        image[i][j] = newColor;
        dfs(image, i+1 , j, currentColor, newColor);
        dfs(image, i-1 , j, currentColor, newColor);
        dfs(image, i , j+1, currentColor, newColor);
        dfs(image, i , j-1, currentColor, newColor);
    }
}

//TC = O(N) m*n
//SC = O(N) or m*n



//01 MAtrix
class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int []>q = new LinkedList<>();
        int dist = 1;
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0)
                    q.add(new int[]{i,j});
                else
                    matrix[i][j] = -1;
            }
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size ;i++){
                int[] curr= q.poll();
                for(int []dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r>=0 && c>=0&& r<matrix.length &&c<matrix[0].length&&matrix[r][c]==-1){
                    matrix[r][c] = dist;
                    q.add(new int[]{r,c});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}

//TC O(N) or m*n
//SC O(N) or m*n

