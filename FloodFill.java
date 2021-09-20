// Time Complexity : O(n)  n=no of elements in tree
// Space Complexity :O(n)   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor){return image;}
        int m=image.length;
        int n=image[0].length;
        LinkedList<int[]> q=new LinkedList<>();
        int oldcolor=image[sr][sc];
        image[sr][sc]=newColor;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        q.add(new int[]{sr,sc});
        while(!q.isEmpty())
        {
            int r,c;
            int[] temp=q.poll();
            for(int[] dir:dirs)
            {
                r=temp[0]+dir[0];
                c=temp[1]+dir[1];
                if(r>=0 && c>=0 && r<m && c<n && image[r][c]==oldcolor)
                {
                    image[r][c]=newColor;
                    q.add(new int[]{r,c});
                }
            }
        }
        return image;
        
    }
}