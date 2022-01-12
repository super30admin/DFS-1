//FloodFill
//https://leetcode.com/submissions/detail/618352704/
//Time: O(m*n)
//Space: O(1)

class Solution {
    
    class Pair {
        int x;
        int y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }     
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int currColor = image[sr][sc];
        
        if(currColor == newColor) {
            return image;
        }
        
        Queue<Pair> q = new LinkedList<>();
        int[][] dirs = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
            
        q.add(new Pair(sr, sc));
        
        while(!q.isEmpty()){
            
            Pair currPair = q.poll();
            image[currPair.getX()][currPair.getY()] = newColor;
            
            for(int[] dir: dirs) {
                
                int row = currPair.getX() + dir[0];
                int col = currPair.getY() + dir[1];
                
                if(row >= 0 && row < image.length && col >=0 && col < image[0].length){
                    
                    if(image[row][col] == currColor) {
                        
                        q.add(new Pair(row, col));
                                                
                    }
                }
            }
            
        }    
        return image;
    }
    
}