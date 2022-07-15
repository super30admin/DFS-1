// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

//Problem statement: https://leetcode.com/problems/01-matrix/

class Solution {
    public int[][] updateMatrix(int[][] m){
        Queue<int []> nm=new LinkedList<>();
        int k=m.length,p=m[0].length;
        int a[][]=new int[k][p];
        for(int i=0;i<k;i++)
        {
            for(int j=0;j<p;j++)
            {
                if(m[i][j]==0)
                    nm.offer(new int []{i,j});
                else
                    m[i][j]=Integer.MAX_VALUE;
            }
        }
        int f[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!(nm.isEmpty()))
        {
            int s[]=nm.poll();
            for(int f1[] : f)
            {
                int c=f1[0]+s[0];
                int d=f1[1]+s[1];
                if(c<0||d<0||c>=k||d>=p||m[c][d]<=m[s[0]][s[1]]+1)
                    continue;
                nm.offer(new int []{c,d});
                m[c][d]=m[s[0]][s[1]]+1;
            }
        }
        return m;
    }
}