class Pair{
int row, col;
Pair(int row,int col){
    this.row =row;
    this.col = col;
}}
class Solution {
    int[][] d ={{0,1},{1,0},{-1,0},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) { 
        if(image[sr][sc] == color){
            return image;
        }
       int f = image[sr][sc];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
       image[sr][sc] = color;
        while(!q.isEmpty()){
           Pair p = q.remove();
           int rp = p.row;
           int cp = p.col;
       for(int[]x :d){
               int r = x[0]+rp;
               int c = x[1]+cp;
           if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c] == f){
               image[r][c] = color;
               
               q.add(new Pair(r,c));
           }
       }}
       return image;
    }
}
//tc=O(mn)
//sc=O(mn)
