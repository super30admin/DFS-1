//Time Complexity=O(M*N)
//Space Complexity=O(M*N)
public class FloodFillBFS {

    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m=image.length;
        int n=image[0].length;
        int x=image[sr][sc];
        image[sr][sc]=color;
        if(x==color) return image;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sr,sc});

        while(!q.isEmpty()){
            int[] curr=q.poll();
            for(int[] dis:dir){
                int nr=curr[0]+dis[0];
                int nc=curr[1]+dis[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==x){
                    image[nr][nc]=color;
                    q.add(new int[]{nr,nc});
                }
            }
        }

        return image;
    }
}
