// Time Complexity: O(m*n) as if we are reaching to as many possible cells from 1 child we are coloring it, deeming it incapable of getting colored again, so another recursion will not attempt to color the same cell
// Space Complexity: O(m*n) as we are adding all neighbours to queue
// Did you complete it on leetcode: Yes
// Any problems faced: Required little help

// Write your approach here
// Idea here is to use BFS for traversing all neighbours simultaneously
// while keeping a visited set to identify we do not want to visit cell again
// we add intial target into queue and while queue is not empty,
// we are polling the cell and updating the color of cell to new color
// then traversing to each child we add them into queue as well and take size again to iterate through all child for polling and recoloring.
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int oldCol = image[sr][sc];
        if(oldCol==newColor) return image;
        
        Queue<int[]> q = new LinkedList<>();
        Set<int[]> set= new HashSet();
        q.add(new int[]{sr,sc});
        set.add(new int[]{sr,sc});
        int[][] dirs = {{1,0}, {0,1}, {0,-1}, {-1,0}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                if(image[curr[0]][curr[1]] == oldCol) {
                    image[curr[0]][curr[1]] = newColor;
                    for(int[] dir: dirs) {
                        int r = curr[0] + dir[0];
                        int c = curr[1] + dir[1];
                        if(r>=0 && r<m && c>=0 && c<n &&
                           image[r][c]==oldCol) {
                            if(!set.contains(new int[]{r,c})){
                                q.add(new int[]{r,c});
                                set.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        return image;
    }
}