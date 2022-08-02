/*
// BFS Solution:
// o(m*n) Space and time complexity
class Solution {
    int [][]dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length==0 || image[sr][sc]== color)
            return image;
        int m =image.length;
        int n =image[0].length;
        Queue<Integer> rows=new LinkedList<>();
        Queue<Integer> cols=new LinkedList<>();
        dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int oldColor=image[sr][sc];
        rows.add(sr);
        cols.add(sc);
        image[sr][sc]=color;
        while(!rows.isEmpty())
        {
            int row=rows.poll();
            int col=cols.poll();
            for(int []dir:dirs)
            {
                int nr=dir[0]+row;
                int nc=dir[1]+col;
                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==oldColor)
                {
                    rows.add(nr);
                    cols.add(nc);
                    image[nr][nc]=color;
                }
            }
        }
        return image;
    }
}
*/
// dfs colution:
// o(m*n) Space and time complexity
class Solution {
    int [][]dirs;
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length==0 || image[sr][sc]== color)
        {
            return image;
        }
        m =image.length;
        n =image[0].length;
        dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int oldColor=image[sr][sc];


        dfs(image,sr,sc,color,oldColor);

        return image;
    }
    private void dfs(int[][] image, int row, int coloumn, int color, int oldColor)

    {
        if(row < 0 || coloumn < 0 || row==m || coloumn == n || image[row][coloumn] != oldColor)
        {
            return;
        }
        image[row][coloumn]= color;
        for(int[] dir:dirs)
        {
            int nr=row +dir[0];
            int nc=coloumn+dir[1];
            dfs(image,nr,nc,color,oldColor);
        }
    }
}

