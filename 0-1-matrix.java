// Time Complexity : O(n)  n=no of elements in tree
// Space Complexity :O(n)   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat.length==0){return mat;}
    LinkedList<int[]> q=new LinkedList<>();
    int m=mat.length,n=mat[0].length;
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(mat[i][j]==0)
            {q.add(new int[] {i,j});}
            else
            {
                mat[i][j]=-1;
            }
        }
    }
        while(!q.isEmpty())
        {
            int[] temp=q.poll();
            int size=q.size();
            for(int dir[]:dirs)
            {
                int r=temp[0]+dir[0];
                int c=temp[1]+dir[1];
                if(r>=0 && c>=0 && r<m && c<n && mat[r][c]==-1)
                {
                    mat[r][c]=mat[temp[0]][temp[1]]+1;
                    q.add(new int[]{r,c});
                }
            }
        }
        return mat;
    }
    }