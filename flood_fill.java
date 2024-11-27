// Time Complexity : O(n)
// Space Complexity :O(n/2)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this :
//approach: by doing bfs we search the elements which has 1 add them into the queue. we then search the 4 directions of that element for 1. if it is present, we add 
// perfomr bfs on that.

// Your code here along with comments explaining your approach
class Solution {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs= new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        Queue<int[]> q=new LinkedList<>();
        int m=image.length;
        int n=image[0].length;
        int oldcol=image[sr][sc];
        if(oldcol==color)   return image;
        q.add(new int[]{sr,sc});
        image[sr][sc]=color;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] cur=q.poll();
                for(int[] dir:dirs)
                {
                    int r=cur[0]+dir[0];
                    int c=cur[1]+dir[1];

                    if(r>=0 && r<m && c>=0 && c<n && image[r][c]==oldcol)
                    {
                        image[r][c]=color;
                        q.add(new int[]{r,c});
                    }
                }

            }
        }
        return image;
    }
}