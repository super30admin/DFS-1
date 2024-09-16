
class FloodFillBFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)return image;
        int[] dx ={-1,0,0,1};
        int[] dy ={0,-1,1,0};
        int m = image.length;
        int n = image[0].length;
        int initcolor = image[sr][sc];
        image[sr][sc]=newColor;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(sr,sc));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair current = q.poll();
                for(int k=0;k<4;k++){
                    int x = current.x+dx[k];
                    int y = current.y+dy[k];
                    if(x>=0 && x < m && y>=0 && y<n&&  image[x][y]==initcolor){
                        image[x][y]=newColor;
                        q.add(new Pair(x,y));
                    }
                }
            }

        }
        return image;
    }
}
class Pair{
    int x,y;
    Pair(int x, int y){
        this.x  = x;
        this.y = y;
    }
}
