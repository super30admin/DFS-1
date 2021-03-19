// TC - O(n), SC - O(n)

// DFS

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        // call method
        if(sr < rows && sc < cols && sr >=0 && sc >= 0){
            floodFill(image, sr, sc, newColor, rows, cols, image[sr][sc]);       
        }
        // return image
        return image;
    }
    
    private void floodFill(int[][] image, int r, int c, int newColor, int rows, int cols, int oldColor){
        // check if row and col are not of bounds of array 
        // we also need to check if image[r][c] is not the initial colour which is image[sr][sc]
        if(r < 0 || c < 0 || r >= rows || c >= cols ||  image[r][c] == newColor || image[r][c] != oldColor){
            return;
        }
        // update value image[r][c] to newColor
        image[r][c] = newColor;
        // dfs call for 4 sides/
        floodFill(image, r+1, c, newColor, rows, cols, oldColor);
        floodFill(image, r-1, c, newColor, rows, cols, oldColor);
        floodFill(image, r, c+1, newColor, rows, cols, oldColor);
        floodFill(image, r, c-1, newColor, rows, cols, oldColor);
    }
}


// BFS

// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//         if(image[sr][sc] == newColor){
//             return image;
//         }
//         int rows = image.length;
//         int cols = image[0].length;
//         Queue<Pair<Integer, Integer>> q = new LinkedList<>();
//         int oldColor = image[sr][sc];
//         image[sr][sc] = newColor;
//         q.add(new Pair<Integer, Integer>(sr, sc));
//         int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
//         while(!q.isEmpty()){
//             // int size = q.size();
//             // for(int j=0; j<size; j++){
//                 Pair<Integer, Integer> pairTemp = q.remove();
//                 for(int i=0; i<dirs.length; i++){
//                     sr = pairTemp.getKey() + dirs[i][0];
//                     sc = pairTemp.getValue() + dirs[i][1];
//                     if(sr>=0 && sr <rows && sc >= 0 && sc<cols && image[sr][sc] == oldColor){
//                         image[sr][sc] = newColor;
//                         q.add(new Pair<Integer, Integer>(sr,sc));
//                     }
//                 }   
//             //}
//         }
//         return image;
//     }
// }