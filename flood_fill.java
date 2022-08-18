// Time Complexity : O(m*n)
// Space Complexity : O(m*n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = image.length;
        int n=image[0].length;
        Queue<Pair<Integer,Integer>> q = new LinkedList();
        q.add(new Pair<Integer,Integer>(sr,sc));
        int samecolor = image[sr][sc];
        if(color==samecolor)
            return image;
        image[sr][sc]=color;
        while(!q.isEmpty()){
            Pair<Integer,Integer> p = q.poll();
            int r = (int)p.getKey();
            int c = (int)p.getValue();
            for(int[] dir: dirs){
                int row = r+dir[0];
                int col = c+dir[1];
                if(row>=0 && row<m && col>=0 && col<n && image[row][col]==samecolor){
                    image[row][col]=color;
                    q.add(new Pair<Integer,Integer>(row,col));
                }
            }
        }
        return image;
    }
}
