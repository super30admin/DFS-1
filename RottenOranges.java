//Time complexity: O(m*n*4)
//Space complexity: O(m*n)
//Executed on leetcode
class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid==null|| grid.length==0)
            return 0;
        
        Queue<int[]> queue= new LinkedList<>();    
        int freshOranges = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)           //Add all the rotten oranges indices to queue.
                {
                    int[] arr = {i,j};  //Traverse through all the indices in queue that are add in previous iteration.
                    queue.add(arr);
                }                       //For every iteration add a minute.
                else if(grid[i][j]==1)  //return time and if cannot rot all the oranges return -1
                    freshOranges++;
            }
        }
        int time = 0;
        while(!queue.isEmpty())
        {
            int qSize = queue.size();
            for(int x=0;x<qSize;x++)
            {
                int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
                int pair[] = queue.poll();
                for(int[] d:dir)
                {
                    int i = pair[0]+d[0];
                    int j = pair[1]+d[1];
                    
                    if(i>=0 && i<n && j>=0 && j<m && grid[i][j]==1)
                    {
                        grid[i][j] = 2;
                        queue.add(new int[]{i,j});
                        freshOranges--;
                    }
                }
            }
            time++;
        }
        
        if(freshOranges!=0) return -1;
        
        return time>0? time-1 : time;
    }
}