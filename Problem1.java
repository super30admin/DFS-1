
// Time Complexity :O(N*M)
// Space Complexity :O(N*M)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


//I use bfs traversal by adding the starting pixel to the queue and changing its color
//I also keep track of the original color to ensure we only fill connected pixels of the same color
//using directions array we add its neighboring pixels to the queue.

class Solution {
    //BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)  //base case
            return image;

        int dirs[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        int n=image.length,m=image[0].length;
        Queue<int[]> q=new LinkedList<>();

        int oricolor=image[sr][sc];

        q.add(new int[]{sr,sc}); 
        image[sr][sc]=color;

        while(!q.isEmpty()){
            int curr[]=q.remove();
            for(int dir[]:dirs){
                int r=curr[0]+dir[0];
                int c=curr[1]+dir[1];
                if(r>=0&&c>=0&&r<n&&c<m&&image[r][c]==oricolor){
                    q.add(new int[]{r,c});          // add the pixel to the queue and change its color
                    image[r][c]=color;
                }
            }
        }
        return image;
    }
}