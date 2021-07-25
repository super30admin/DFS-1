// Time Complexity : o(mn)
// Space Complexity : o(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    
    //using bfs
    public int[][] updateMatrix(int[][] mat) {
       
        if(mat==null || mat.length==0)
            return mat;
        
        Queue<int[]> queue=new LinkedList<>();
        int m=mat.length;
        int n=mat[0].length;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                    queue.add(new int[]{i,j});
                else
                    mat[i][j]=-1;
            }
        }
        
        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};
        int dist=1; // coz all o's are already pushed so next level will be 1 so dist=1
        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            for(int k=0;k<size;k++)
            {
                int[] curr=queue.poll();
                for(int[] dir:dirs)
                {
                     int nR=curr[0]+dir[0];
                     int nC=curr[1]+dir[1];
                if(nR<m && nR>=0 && nC>=0 && nC<n && mat[nR][nC]==-1)
                {
                    mat[nR][nC]=dist;
                    queue.add(new int[]{nR,nC});
                }
               
            }
        }
            dist++;
        
    }
        return mat;
    }
}