// Time Complexity :O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode 733: yes
/*Approach: we have to check if given cell has the newColor already if so we can return the input matrix as it is
else we will have to change the present color of the given cell to a new color and also all its neighbors
(in the 4 directions)having the old color of the given cell to the new cell*/


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null||image.length==0||image[sr][sc]==newColor)
            return image;
        int m=image.length;
        int n=image[0].length;
        int color=image[sr][sc];
        image[sr][sc]=newColor;
        Queue<int[]> q=new LinkedList<>();
       int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int[] curr=q.poll();
            for(int[] dir:dirs){
                int nr=curr[0]+dir[0];
                int nc=curr[1]+dir[1];
                if(nr>=0&&nr<m&&nc>=0&&nc<n&&image[nr][nc]==color)
                {
                    image[nr][nc]=newColor;
                    q.add(new int[]{nr,nc});
                }
            }
        }
       return image;
    }
}