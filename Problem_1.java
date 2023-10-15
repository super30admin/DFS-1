/* 

## Problem1 (https://leetcode.com/problems/flood-fill/)

Time Complexity : O(m*n)
Space Complexity : O(m*n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        Queue<int[]> q = new LinkedList<int[]>();
        int clr = image[sr][sc];
        if(clr == color){
            return image;
        }

        q.add(new int[] {sr,sc});
        image[sr][sc] = color;
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
            int[] index = q.poll();
            for(int[] dir : dirs){
                int nr = index[0] + dir[0];
                int nc = index[1] + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    if( image[nr][nc] == clr){
                        q.add(new int[] {nr,nc});
                        image[nr][nc] = color;
                    }
                }
            }
        }

        return image;

    }
}