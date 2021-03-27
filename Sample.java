// Time Complexity : O(m*n) -> image rows n columns
// Space Complexity : O(n) -> max number of cells in the queue.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
 * Using a BFS approach, initially adding the start row and column indexes to the queue. Following the four directions,
 * each one would be checked for a valid color and if present, it will be changed to a new color. * 
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image[0] == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor)
            return image;
        
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{sr,sc});
        
        int row = image.length;
        int col = image[0].length;
        
        int validColor = image[sr][sc];
        
        image[sr][sc] = newColor;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                int[] temp = queue.poll();
                
                int n = temp[0];
                int m = temp[1];
                
                for(int[] dir:dirs){
                    if(n+dir[0]>=0 && n+dir[0]<row && m+dir[1]>=0 && m+dir[1]<col && image[n+dir[0]][m+dir[1]] == validColor){
                        image[n+dir[0]][m+dir[1]] = newColor;
                       queue.add(new int[]{n+dir[0],m+dir[1]}); 
                    }
                    
                }

            }

        }
        
        return image;
    }
}

//Time Complexity : O(m*n) -> image rows n columns
//Space Complexity : O(n) -> max number of cells in the queue.
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no


//Your code here along with comments explaining your approach
/*
* Using a BFS approach, added every cell with '0' to the queue. The first level constitues of all the cells reachable by '0' in 4 possible directions.
* The distance is incremented on every level and each cell is replaced with the new distance which is reachable. 
*/



class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return matrix;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == 0)
                    queue.add(new Pair<Integer,Integer>(i,j));
                else
                    matrix[i][j] = -1;
            }
        }
        
        
        int dist = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                Pair<Integer,Integer> currPair = queue.poll();
                
                for(int[] dir:dirs){
                    int r = currPair.getKey() + dir[0];
                    int c = currPair.getValue() + dir[1];
                    
                    if(r>=0 && r<row && c>=0 && c<col && matrix[r][c] == -1){
                        queue.add(new Pair<Integer,Integer>(r,c));
                        matrix[r][c] = dist;
                    }
                }
                
            }
            
            dist++;
        }
        
        return matrix;   
    }
}