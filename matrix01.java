//TC : O(mxn) SC:(mxn)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null||mat.length==0) return mat;
        Queue<int[]> q = new LinkedList();
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                    q.add(new int[]{i,j});
                else
                if(mat[i][j] == 1)
                    mat[i][j] = -1;
            }
        }
        int level =1;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                int[] idx = q.poll();
                for(int[] dir : dirs)
                {
                    int r = idx[0]+dir[0];
                    int c = idx[1]+dir[1];
                    if(r>=0&&r<m&&c>=0&&c<n&&mat[r][c]==-1)
                    {
                        mat[r][c] = level;
                        q.add(new int[] {r,c});
                    }
                }
            }
            level++;
        }
        return mat;
    }
}