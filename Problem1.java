//Accepted on LT
//Perform BFS on all paths and check for color change.
//Time O(mn)[probably as worst case we need to change whole matrix]
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sp = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        int pixelc = image[sr][sc];
        image[sr][sc]= -1;
        int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        int[] element = {sr, sc};
        q.add(element);
        while(!q.isEmpty()){
            int[] idx = q.poll();
            int x;
            int y;
            for(int[] c: d){
                x = idx[0] + c[0];
                y = idx[1] + c[1];
                if(x>=0 && x<m && y>=0 && y<n){
                    if(image[x][y]==pixelc){
                        image[x][y] = -1;
                        int[] e = {x,y};
                        q.add(e);
                    }
                }

            }
        }
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if(image[i][j]==-1){
                    image[i][j]=color;
                }
            }
            
        }
        return image;
        
    }
}