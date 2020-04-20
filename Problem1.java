// Time Complexity: O(m*n)
// Space Complexity: O(m*n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //edge case
        if(image == null || image.length == 0 || image[0].length == 0){
            return image;
        }
        
        int row = image.length;
        int col = image[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr,sc});
        
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        
        while(!q.isEmpty()){
            int[] start = q.poll();
            
            int start_i = start[0];
            int start_j = start[1];
            
            int startColor = image[start_i][start_j];
            if(startColor == newColor){
                continue;
            }
            image[start_i][start_j] = newColor;
            
            for(int[] direction: directions){
                int r = start_i + direction[0];
                int c = start_j + direction[1];
                
                if(r >= 0 && r<row && c >= 0 && c<col && (image[r][c] == startColor)){
                    q.add(new int[] {r,c});
                }
            }
        }      
        
        return image;
    }
}
