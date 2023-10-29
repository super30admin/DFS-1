
// Time Complexity :O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int m = image.length;
    int n = image[0].length;
    Queue<int[] > q = new LinkedList<>();
    int c = image[sr][sc];
    if(c == color) return image;
    q.add(new int[]{sr,sc});
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    while(!q.isEmpty()){
       int size= q.size();
    for(int i=0; i<size; i++){
       int[] curr= q.poll();
        
        image[curr[0]][curr[1]] = color;
       
        for(int[] dir: dirs){
            int nr = curr[0] + dir[0];
            int nc = curr[1] + dir[1];
            
            if(nr>=0 && nr <m && nc >=0 && nc <n && image[nr][nc] ==c){
                image[nr][nc] =color;
                 q.add(new int[]{nr,nc});
            }
        }
    
    }
        
        
    } 
       return image; 
    }
}
