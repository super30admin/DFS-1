//https://leetcode.com/problems/flood-fill/

// Time Complexity :O(mxn) 
// Space Complexity :O(mxn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    int[][] dirs;
    int row,col;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //when image is null or new color is equal to the old color
        if(image==null|| image[sr][sc]==newColor) return image; 
        dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        row=image.length; col=image[0].length;
        int oldcolor=image[sr][sc];
        image[sr][sc]=newColor;
        Queue<int[]> q=new LinkedList<>(); // dont use Integer[] use int[]
        q.add(new int[]{sr,sc});
       
        while(!q.isEmpty()) //for every necolor check the 4 directions and change old color to newcolor
        {
            int[] present=q.poll();
            for(int[] dir:dirs)
            {
                int r=present[0]+dir[0];
                int c=present[1]+dir[1];
                if(r>=0 && c>=0 && r<row && c<col && image[r][c]==oldcolor)
                {
                    image[r][c]=newColor;
                    q.add(new int[]{r,c});
                 
                }
            }
        }
        return image;
    }
   
}