// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image.length == 0 || image[0].length==0 || image == null) return image;
        int color = image[sr][sc];
        if(color != newColor) fill(image,sr,sc,color,newColor);
        return image;
    }
    public void fill(int[][] image, int sr,int sc,int color,int newColor){
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        if(image[sr][sc] == color){
            image[sr][sc] = newColor;
            for(int[] d:dirs){
                int r = d[0]+sr;
                int c = d[1]+sc;
                if(r >=0 && r<image.length && c>=0 && c<image[0].length){
                    fill(image,r,c,color,newColor);
                }
            }
        }
    }
}

/* BFS Approach 
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> que = new LinkedList();
        int color = image[sr][sc];
        if(color != newColor){
            image[sr][sc] = newColor;
            que.add(new int[]{sr,sc});
        }
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!que.isEmpty()){
            int[] n = que.poll();
            for(int[] d:dirs){
                int r = d[0]+n[0];
                int c = d[1]+n[1];
                if(r >=0 && r<image.length && c>=0 && c<image[0].length && image[r][c] == color){
                    image[r][c] = newColor;
                    que.add(new int[]{r,c});
                }
            }
        }
        return image;
    }
}

*/
