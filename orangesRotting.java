// Time Complexity : O(n*n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int orangesRotting(int[][] grid) {
       
        if(grid.length==0) return -1;
        Queue<int[]> q = new LinkedList();
        int r = grid.length;
        int c = grid[0].length;
        
        // find infected orange and orange count
        int oranges = 0;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(grid[i][j]==2) q.add(new int[]{i,j});
                if(grid[i][j]==1) oranges++;
            }
        }
        
        int mins = 0;
        if(oranges==0) return mins;
        
        // Do BFS 
        int dirs[][] = {{0,1},{-0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()) {
            
            
            int size = q.size();
            mins++;
            
            for(int i = 0;i<size;i++) {
                
                int[] idx = q.poll();
                for(int[] dir : dirs) {

                    int newX = idx[0]+dir[0];
                    int newY = idx[1]+dir[1];

                    if(newX<0 || newX>=r || newY<0 || newY>=c || grid[newX][newY]==2 || grid[newX][newY]==0 ) continue;
                    grid[newX][newY] = 2;
                    q.add(new int[]{newX,newY});
                    oranges--;

                }
            }
        }
        return oranges==0?mins-1:-1;
    }
}
