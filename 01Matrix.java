//https://leetcode.com/problems/01-matrix/

// Time Complexity :O(mxn) 
// Space Complexity :O(mxn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0;i<row;i++) //check for 0's add them to queue so that ones in its neigjbours are in distance 1
        {
            for(int j=0;j<col;j++)
            {
                if(mat[i][j]==0)
                    q.add(new int[]{i,j});
                else
                    mat[i][j]=-1;//make 1 to -1 to avoid collapse between distance 1 and element 1
            }
        }
        int dist=1;
        //first travesal would be from 0's to neighbouring 1 
        //second traversal would be from 1 to its neighbours 1 whose distance now be 2
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] curr=q.poll();
                for(int[] dir:dirs)
                {
                    int nr=curr[0]+dir[0];
                    int nc=curr[1]+dir[1];
                    if(nr>=0 && nc>=0 && nr<row && nc<col && mat[nr][nc]==-1)
                    {
                        q.add(new int[]{nr,nc});
                        mat[nr][nc]=dist;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}