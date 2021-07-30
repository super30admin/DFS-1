//TimeComplexity:O(M*N) Image size
//Space Complexity:O(M*N)

class Pair {
    int row;
    int col;

    Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Pair> queue = new LinkedList<>();

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int color =image[sr][sc];

        if(color!=newColor) {
            image[sr][sc] = newColor;
            queue.add(new Pair(sr,sc));

            while(!queue.isEmpty()){
                Pair p = queue.poll();
                for(int[] dir: dirs){
                    int r = p.row + dir[0];
                    int c = p.col + dir[1];

                    if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c] == color){
                        image[r][c] = newColor;
                        queue.add(new Pair(x,y));
                    }

                }
            }
        }
        return image;
    }

}
