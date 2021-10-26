//TC:O(mxn)
//SC:O(mxn)
//Successfully ran on leetcode
class Solution {
    public int[][] updateMatrix(int[][] mat)
    {
        if(mat==null || mat.length==0 ||mat[0].length==0 ||mat[0]==null)
            return mat;

        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                    q.add(new int[]{i,j});
                else
                    mat[i][j]=Integer.MAX_VALUE;
            }
        }

        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};

        while(!q.isEmpty())
        {
            int[] front=q.poll();
            for(int[] dir:dirs)
            {
                int i=front[0]+dir[0];
                int j=front[1]+dir[1];

                int old=mat[front[0]][front[1]];
                if(i>=0 && j>=0 && i<mat.length && j<mat[0].length && (old+1<mat[i][j]))
                {
                    q.add(new int[]{i,j});
                    mat[i][j]=old+1;
                }
            }
        }
        return mat;
    }
}
