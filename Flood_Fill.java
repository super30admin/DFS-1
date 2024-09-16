Time Complexity: O(mxn)
Space Complexity: O(mxn)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length ==0 || image[sr][sc]==newColor)
            return image;
        
        int m = image.length;
        int n= image[0].length;
        int color = image[sr][sc];
        Queue<int []> q = new LinkedList<>();
        image[sr][sc] = newColor;
        q.add(new int[] {sr,sc});
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                int [] curr = q.poll();
                for(int[] d : dirs)
                {
                    int row = d[0] + curr[0];
                    int col = d[1] + curr[1];
                    if(row >=0 && row < m && col >=0 && col <n && image[row][col]== color)
                    {
                        image[row][col] = newColor;
                        q.add(new int[] {row, col});
                    }
                }
            }
        }
        
        return image;
        
    }
}
