//Time Complexity:O(mn)
//Space Complexity:O(mn)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image[sr][sc]==newColor)
            return image;
        int m=image.length;
        int n=image[0].length;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sr,sc});
        int color=image[sr][sc];
        image[sr][sc]=newColor;
        while(!q.isEmpty()){
            int curr[]=q.poll();
            for(int [] dir: dirs){
                int nr=curr[0]+dir[0];
                int nc=curr[1]+dir[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==color) {
                    System.out.println(image[nr][nc]);
                
                    image[nr][nc]=newColor;
                    q.add(new int []{nr,nc});
                }
            }
        }
        return image;
    }
}
