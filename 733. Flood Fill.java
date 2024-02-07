// Time Complexity : O(m*n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[][] floodFill(int[][] image, int a, int b, int color) {

        // BFS solution
        Queue<int[]> q = new LinkedList<>();
        int originalColor = image[a][b];

        if(color == originalColor) return image;

        q.offer(new int[]{a,b});
        image[a][b] = color;

        while(!q.isEmpty()){
            int[] polled = q.poll();
            int sr = polled[0];
            int sc = polled[1];

            if(sr > 0 && image[sr-1][sc] == originalColor) {
                image[sr-1][sc] = color;
                q.offer(new int[]{sr-1, sc});
            }
            if(sr < image.length-1 && image[sr+1][sc] == originalColor){
                image[sr+1][sc] = color;
                q.offer(new int[]{sr+1, sc});
            }
            if(sc > 0 && image[sr][sc-1] == originalColor) {
                image[sr][sc-1] = color;
                q.offer(new int[]{sr, sc-1});
            }
            if(sc < image[sr].length-1 && image[sr][sc+1] == originalColor){
                image[sr][sc+1] = color;
                q.offer(new int[]{sr, sc+1});
            }
        }

        return image;
        
    }
}
