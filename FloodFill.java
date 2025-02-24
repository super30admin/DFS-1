// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
BFS
 */
class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null) return image;
        int originalColor=image[sr][sc];
        if(image[sr][sc]==color)
            return image;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(sr);
        queue.add(sc);
        image[sr][sc]=color;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int cr=queue.poll();
            int cc=queue.poll();
            for(int[] dir:dirs){
                int nr=cr+dir[0];
                int nc=cc+dir[1];
                if(nr>=0 && nr<image.length && nc>=0 && nc<image[0].length && image[nr][nc]==originalColor){
                    queue.add(nr);
                    queue.add(nc);
                    image[nr][nc]=color;
                }
            }
        }
        return image;
    }

}