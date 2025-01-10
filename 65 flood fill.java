// Time Complexity : O(n)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int m , n ;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.m  = image.length;
        this.n = image[0].length;
        this.dirs= new dirs[][] {{-1,0},{1,0},{0,1},{0,-1}};
        int oldcolor = image[sr][sc];
        if(oldcolor== color) return image;
        Queue<integer> q= new LinkedList<>();
        q.add[sr];
        q.add[sc];
        image[sr][sc] == color;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0;i<size;i++)
            {

            }
        }

    }
}