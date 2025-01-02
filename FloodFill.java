class Solution {
   
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int len = image.length;
        int wid = image[0].length;
        
         int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Queue<int[]> q = new LinkedList<>();
        int ccol = image[sr][sc];
        image[sr][sc] = color;
        
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] d:dir){
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];

                if(nr>=0 && nr < len && nc >=0 && nc<wid && image[nr][nc]!= color && image[nr][nc]== ccol){
                        image[nr][nc]= color;
                        q.add(new int[]{nr,nc});
                }

            }
        }

        return image;
    }
}