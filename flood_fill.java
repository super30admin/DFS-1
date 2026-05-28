//time complexity:O(m*n)
//space complexity:O(m*n)
//bfs sol - 
class Solution {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        this.dirs= new int [][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        if(image[sr][sc] == color) return image;

        q.add(new int[]{sr,sc});
        int og= image[sr][sc];
        image[sr][sc]=color;
        while(!q.isEmpty()){
            // int size=q.size(); _>>>>>>>>>>>>>>>>>> only useful for level order, here we are just flooding so not required
            // for(int i=0;i<size;i++){
            int[] curr=q.poll();
            for(int[] dir:dirs){
                int r=curr[0]+dir[0];
                int c=curr[1]+dir[1];
                if(r>=0 && c>=0 && r<m && c<n && image[r][c]==og){
                    image[r][c]=color;
                    q.add(new int[]{r,c});
                }
            }
        }
        return image;
    }
}