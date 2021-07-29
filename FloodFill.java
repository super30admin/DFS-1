//BFS
//TimeComplexity:O(M*N)
//Space Complexity:O(M*N) Recursive Stack
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Pair> queue = new LinkedList<>();
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int color =image[sr][sc];
        if(color!=newColor){
            image[sr][sc] = newColor;
            queue.add(new Pair(sr,sc));

            while(!queue.isEmpty()){
                Pair p = queue.poll();
                for(int i=0;i<directions.length;i++){
                    int x = p.row+ directions[i][0];
                    int y = p.col+ directions[i][1];

                    if(x>=0 && x<image.length && y>=0 && y<image[0].length && image[x][y] == color){
                        image[x][y] = newColor;
                        queue.add(new Pair(x,y));
                    }

                }
            }}
        return image;
    }

}
class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }

}}