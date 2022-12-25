// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

/*

We are provided with a target place on image , when we click on that place, turn it into the target color and if its 4directional adjacents were the same color
change them too
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        Queue<int[]> queue = new LinkedList<int[]>();
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int currentColor = image[sr][sc];
        if(currentColor == color) return image;
        queue.add(new int[] {sr,sc});

        while(!queue.isEmpty()){
            // check if its the same color
            int[] curr = queue.poll();
            if(image[curr[0]][curr[1]] == currentColor){
                // change to target
                image[curr[0]][curr[1]] = color;
                // go diff directions
                for(int[] dir : dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    // check bounds
                    if(!(nr<0 || nr>=image.length || nc<0 || nc>=image[0].length) && image[nr][nc] == currentColor){
                        queue.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return image;
    }
}