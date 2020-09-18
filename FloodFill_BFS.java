// Time Complexity : O(m*n) m = number of rows, n = number of columns
// Space Complexity : O(m*n) m = number of rows, n = number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0)  return image;
        
        if(image[sr][sc] == newColor)   return image;
        
        int dirs[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        
        Queue<Pair<Integer,Integer>> queue = new LinkedList();
        queue.offer(new Pair<>(sr,sc));
        int currentColor = image[sr][sc];
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0;i<size; i++){
                
                Pair<Integer,Integer> p = queue.poll();
                image[p.getKey()][p.getValue()] = newColor;
                for(int dir[]:dirs){
                    int x = dir[0] + p.getKey();
                    int y = dir[1] + p.getValue();
                    if(x >= 0 && x < image.length &&
                                y >= 0 && y < image[0].length &&
                                image[x][y] == currentColor){
                        
                        image[x][y] = newColor;
                        
                        queue.offer(new Pair<>(x,y));
                    }
                }
            }
        }
        return image;
    }
}
