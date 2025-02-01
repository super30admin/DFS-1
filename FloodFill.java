class Solution {
	//Time Complexity: O(n*m)
	//Space Complexity: O(n*m)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if (image[sr][sc] == color) return image;
       Queue<int[]> q = new LinkedList<>();
       int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

       int startPos[] = {sr, sc};
    int r = image.length;
    int c = image[0].length;
    int oldColor = image[sr][sc];
    image[sr][sc] = color;
       q.add (startPos);
       while (!q.isEmpty()){
        int len = q.size();
            for (int i = 0;i < len;i++) {
                // check all 4 pos
                int[] pos = q.poll();
                for (int[] dir : dirs){
                    int nr = pos[0] + dir[0]; 
                    int nc = pos[1] + dir[1];
                    if (nr >= 0 && nr < r && nc >=0 && nc < c && image[nr] [nc] == oldColor){
                    q.add (new int[]{nr,nc});
                    image[nr][nc] = color;
                   } 
                }
            }
       }
       return image;
    }
    }
