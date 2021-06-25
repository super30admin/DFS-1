//time and space complexity:O(m x n)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new int[] {i,j});//add all
                    //the 0s to the queue
                }
                else
                {
                    mat[i][j]=-1;//make all the elements other than 0 to -1
                }
            }
        }
        int dist=1;
        int[][] dirs= {{0,1},{0,-1},{-1,0},{1,0}};
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] curr=q.poll();
                for(int[] dir: dirs)
                {
                    int r=dir[0]+curr[0];
                    int c=dir[1]+curr[1];
                    //check for the neighbours and set the particular 
                    //element to dist
                    if(r>=0 && c>=0 && r<m && c<n && mat[r][c]==-1)
                    {
                        q.add(new int[] {r,c});
                        mat[r][c]=dist;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}
