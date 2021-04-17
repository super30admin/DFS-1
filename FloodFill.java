//BFS
//Time Complexity : O(m*n)
//Space Complexity : O(m*n). In worst case, the queue will occupy all the cells 
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null||image.length==0||image[sr][sc]==newColor){
            return image;
        }
        int r = image.length;
        int c = image[0].length;
        //use a queue to perform a bfs
        Queue<int[]> q = new LinkedList<>();
        //direction array to find the four cornors
        int dirs[][] = {{0,-1},{1,0},{0,1},{-1,0}};
        //store the source node value
        int prev = image[sr][sc];
        image[sr][sc] = newColor;
        //add the source node to the queue
        q.add(new int[]{sr,sc});
        //start thr bfs traversal
        while(!q.isEmpty()){
            int cur[] = q.poll();
            //determine the neighbours
            for(int dir[] : dirs){
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if(row>=0 && row<r && col>=0 && col<c && image[row][col]==prev){
                    image[row][col] = newColor;
                    q.add(new int[]{row, col});
                }
            }
        }
        return image;
    }
}
//DFS
//Time Complexity : O(m*n)
//Space Complexity : O(m*n). In worst case, the recursive stack will occupy all the cells 
class Solution {
    int r,c,prev;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null||image.length==0||image[sr][sc]==newColor){
            return image;
        }
        r = image.length;
        c = image[0].length;
        
        //store the source node value
        prev = image[sr][sc];
        dfs(image,sr,sc,newColor);
        return image;
    }
    private void dfs(int[][] image,int cr, int cc,int newColor){
        if(cr<0 || cr>=r || cc<0 || cc>=c || image[cr][cc]!=prev){
            return;
        }
        //change the color
        image[cr][cc] = newColor;
        //direction array to find the four cornors
        int dirs[][] = {{0,-1},{1,0},{0,1},{-1,0}};
         for(int dir[] : dirs){
                int row = cr + dir[0];
                int col = cc + dir[1];
                dfs(image,row,col,newColor);
         }
    }
}