//TC:O(mxn)
//SC:O(mxn)
//Successfully ran on leetcode
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int n=image.length;
        int m=image[0].length;

        int[][] output=new int[n][m];


        Queue<int[]> q=new LinkedList<>();

        int[][] dirs={{0,-1},{-1,0},{0,1},{1,0}};

        q.add(new int[]{sr,sc});

        int col=image[sr][sc];

        while(!q.isEmpty())
        {
            int size=q.size();

            for (int x=0;x<size;x++)
            {
                int[] front=q.poll();

                image[front[0]][front[1]]=newColor;

                for(int[] dir:dirs)
                {
                    int i=dir[0]+front[0];
                    int j=dir[1]+front[1];

                    if(i>=0 && j>=0 && i<n && j<m && image[i][j]==col && image[i][j]!=newColor)
                        //System.out.println(image[i][j]+" "+image[sr][sc]);
                        q.add(new int[]{i,j});
                }

            }
            //System.out.println(q);
        }
    return image;
    }
}
