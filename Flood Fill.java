class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        LinkedList<Pair<Integer, Integer>> q = new LinkedList();
        HashSet<Pair<Integer, Integer>> visited = new HashSet(); 
        int ROWS = image.length;
        int COLS = image[0].length;
        int sourceColour = image[sr][sc];
        int[][] directions = {{0,1},{0, -1}, {1, 0}, {-1, 0}};
        q.add(new Pair(sr, sc));
        visited.add(new Pair(sr, sc));
        
        while(!q.isEmpty()){
            
            //We need to push the co-ordinates in the queue
            Pair<Integer, Integer> cell = q.removeFirst();
            int i = cell.getKey();
            int j = cell.getValue();
            //Color the removed node.
            image[i][j] = newColor;
            
            //check all four neighbors of a given vertex.
            
            for(int[] direction : directions){
                
                //Base cases
                int nr = i + direction[0];
                int nc = j + direction[1];
                if((nr >= 0 && nr < ROWS) && (nc >= 0 && nc < COLS) && image[nr][nc] == sourceColour && !visited.contains(new Pair(nr ,nc))){
                     Pair neighbor = new Pair(nr, nc);
                    q.add(neighbor);
                    visited.add(new Pair(nr, nc));
                }
                
            }
            
        }
        
        return image;
    }
}