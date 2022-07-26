//Time Complexity:O(m*n)
//Space Complexity:O(m*n)
//BFS:If pixel color is not same whose color changed the traversal comes to mind.Here taking 2 queues one for row and 2 for columns to maintain the integer array.Check for 4 directions up down,left,right startting from the image[sr][sc] value then substract from my row to go up,check right its direction if its 0 -so dont see the changes in color so not changed the value.It will check for next value for down it reaches the limit then it goes the out of bound.

class Solution {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color) return image;
        
        //BFS Queue solution 1-for row,2 for col
        int m = image.length;
        int n = image[0].length;
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        dirs = new int [][]{{-1,0},{1,0},{0,-1},{0,1}};//UDLR
        int oldColor = image[sr][sc];
        rows.add(sr);
        cols.add(sc);
        image[sr][sc] = color;
        while(!rows.isEmpty()){
            int row = rows.poll();
            int col = cols.poll();
            for(int[] dir : dirs){
                int nr = row+dir[0];
                int nc = col+dir[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==oldColor){
                    rows.add(nr);
                    cols.add(nc);
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}