//TimeComplexity: O(n)
//SpaceComplexity: O(n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image.length==0 || newColor==image[sr][sc]) return image;
        int m=image.length,n=image[0].length;
        int color=image[sr][sc];
        image[sr][sc]=newColor;
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{sr,sc});
        int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] curr= q.poll();
                for(int[] dir:dirs){
                    int r = dir[0]+curr[0];
                    int c = dir[1]+curr[1];
                    if(r<m && r>=0 && c<n && c>=0 && image[r][c]==color){
                        image[r][c]=newColor;
                        q.add(new int[]{r,c});
                    }
                }
            }
        }
        return image;
    }
}