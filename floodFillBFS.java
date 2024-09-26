class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m=image.length;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q=new LinkedList<>();
        int n=image[0].length;
        int color=image[sr][sc];
        q.add(new int[]{sr,sc});
        image[sr][sc]=-1;
        while(!q.isEmpty())
        {
            int[] src=q.poll();
            for(int[] dir:dirs)
            {
                //System.out.println("src"+src[0]+" "+src[1]);
                int r=src[0]+dir[0];
                int c=src[1]+dir[1];
                if(r>=0 && r<m && c>=0 && c<n && image[r][c]==color)
                {
                    //System.out.println("next rows"+r+" "+c);
                    image[r][c]=-1;
                    q.add(new int[]{r,c});
                }
            }
        }
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(image[i][j]==-1)
                    image[i][j]=newColor;
            }
        return image;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)