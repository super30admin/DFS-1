class Solution {
    
    int[][]dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    /*
    method1 - Using BFS to solve
    time complexity: O(m *n)
    space complexitu : O(m * n)
    */
    Queue<int[]> queue;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0){
            return image;
        }
        int m = image.length;
        int n = image[0].length;
        
        //keep record of original color 
        int original = image[sr][sc];
        
       this.queue = new LinkedList<>();
        //add the sr,sc node to the queue
        queue.add(new int[]{sr,sc});
        image[sr][sc] = newColor;
        BFS(image,original,newColor,m,n);
        return image;
        
    }
    
    private void BFS(int[][] image ,int original, int  newColor,int m, int n)
    {
             //start BFS traversal
        while(!queue.isEmpty()){
            int[]point = queue.poll();
            int r = point[0];
            int c = point[1];
            image[r][c] = newColor;
            for(int[]d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];
                
                //check the boundary consitions
                if(nr >= 0 && nr < m  && nc >= 0 && nc < n && image[nr][nc] == original){
                    if(image[nr][nc] != newColor){
                        image[nr][nc] = newColor;
                        queue.add(new int[]{nr,nc});
                    }
                }
                    
            }
        }
    }
}