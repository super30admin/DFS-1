// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
        int oldcolor=grid[sr][sc];
        Queue<Integer> row_q=new LinkedList<Integer>();
        Queue<Integer> col_q=new LinkedList<Integer>();
        
        row_q.add(sr);
        col_q.add(sc);
        if(newColor==oldcolor){
            return grid;
        }
        
        while(row_q.isEmpty()!=true){
            int row=row_q.poll();
            int col=col_q.poll();
            grid[row][col]=newColor;
           
            if(row+1<=grid.length-1){
                if(grid[row+1][col]==oldcolor){
                   
                    
                    row_q.add(row+1);
                    col_q.add(col);
                    grid[row+1][col]=newColor;
                }
                
            }
            if(row-1>=0){
                if(grid[row-1][col]==oldcolor){
                   
                    row_q.add(row-1);
                    col_q.add(col);
                    grid[row-1][col]=newColor;
                    
                }
                
            }
            if(col-1>=0){
                if(grid[row][col-1]==oldcolor){
                  
                    row_q.add(row);
                    col_q.add(col-1);
                    grid[row][col-1]=newColor;
                  
                }
                
            }
            if(col+1<grid[0].length){
                if(grid[row][col+1]==oldcolor){
                  
                    row_q.add(row);
                    col_q.add(col+1);
                    grid[row][col+1]=newColor;
                    
                }
                
            }
        }
        return grid;
        
    }
}