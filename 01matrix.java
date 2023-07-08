// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// First we are iterating through the matrix and add all the indices of 0 to the queue and change the other values to -1;
// now we start performing BFS and when we find a neighbour with -1 we replace it with distance and increment the dist value by 1 after each level


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>(); // space 0(mn)
        for(int i=0;i<n;i++) //mn
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new int[]{i,j});
                }else 
                {
                    mat[i][j]= -1;
                }
            }
        }
        int dist=1;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                int[] curr= q.poll();
                for(int[] dir:dirs)
                {
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr>=0 && nr< n && nc>=0 && nc< m && mat[nr][nc]==-1)
                    {
                        mat[nr][nc]= dist;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}