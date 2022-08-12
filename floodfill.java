// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    //int[] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        int m = image.length;
        int n = image[0].length;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        
        int oc=image[sr][sc];
        image[sr][sc]=color;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int nr=dir[0] + curr[0];
                int nc=dir[1] + curr[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==oc){
                    image[nr][nc]=color;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        
        return image;
    }
}