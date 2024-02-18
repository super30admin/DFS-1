// Time - O(mn)
//Space - O(mn)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        int srccolor = image[sr][sc];
        if(srccolor==color){
            return image;
        }
        int m = image.length;
        int n=image[0].length;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair<Integer,Integer>(sr,sc));
        while(!q.isEmpty()){
            Pair<Integer,Integer> p =q.poll();
            int r = p.getKey();
            int c = p.getValue();
            image[r][c]=color;
            for(int[] dir: dirs){
                int row = r+dir[0];
                int col = c+dir[1];
                if(row>=0 && row<m && col>=0 && col<n && image[row][col]==srccolor){
                    q.add(new Pair<Integer,Integer>(row,col));
                }

            }

        }
        return image;
        
    }
}
