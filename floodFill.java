/*
Time Complexity: O(N), where N is the number of pixels in the image. We might process every pixel.
Space Complexity: O(N), the size of the implicit call stack when calling dfs.*/
class Solution {
    int row , col;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //edge case
        if(image == null || image.length ==0 || image[0].length ==0)
            return image;
        
        row = image.length;
        col = image[0].length;
        //floodFillBFSUtil(image, sr, sc, newColor, image[sr][sc]);
        if( image[sr][sc] != newColor)
            floodFillDFSUtil(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    /*
    Time Complexity: O(N), where N is the number of pixels in the image. We might process every pixel.
    Space Complexity: O(N), the size of the implicit call stack when calling dfs.
    */
    private void floodFillDFSUtil(int[][] image, int x, int y, int newColor, int oldColor){
        //base case
        if(!isValidIndex(x,y))
            return;
        if(image[x][y] == oldColor){
            image[x][y] =newColor;
            floodFillDFSUtil(image, x+1, y, newColor, oldColor);
            floodFillDFSUtil(image, x-1, y, newColor, oldColor);
            floodFillDFSUtil(image, x, y+1, newColor, oldColor);
            floodFillDFSUtil(image, x, y-1, newColor, oldColor);
        }
    }
    private void floodFillBFSUtil(int[][] image, int sr, int sc, int newColor, int oldColor){
        int[][] dirs ={ {0,1},{0,-1},{-1,0},{1,0}};
        
        //add the starting cell in the queue;
        Queue<Cell> q = new LinkedList<>();
        if(oldColor != newColor)
            q.add(new Cell(sr, sc));
        
        while(!q.isEmpty()){
            Cell c= q.remove();
            image[c.x][c.y] =newColor;
            for(int [] dir: dirs){
                int newX = c.x+ dir[0];
                int newY = c.y+ dir[1];
                if(isValidIndex(newX, newY) && image[newX][newY] == oldColor)
                    q.add(new Cell(newX,newY));
            }
        }
    }
    private boolean isValidIndex(int x, int y){
        return x>=0 && x< row && y>=0 && y< col;
    }
}
class Cell{
    int x, y;
    public Cell(int x, int y){
        this.x= x;
        this.y=y;
    }
}
