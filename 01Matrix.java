// TC - O(n), SC - O(n)

class Solution {
    // Initializing dirs array
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Add all 0's corresponding i and j indexes to queue
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        // Iterate over matrix, if value is 0, add indexes as pair to queue else keep it as Integer.MAX_VALUE(univisited node).
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j] == 0){
                    q.add(new Pair<Integer, Integer>(i, j));
                }else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // Iterate while q is not empty, remove pair from q and extract key and value
        while(!q.isEmpty()){
            Pair<Integer, Integer> pair = q.poll();
            int x = pair.getKey();
            int y = pair.getValue();
            // Iterate over dirs array and get new row and new col value
            for(int[] dir : dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                // checking new row and new col are valid
                if(newX < 0 || newY < 0 || newX >= rows || newY >= cols || matrix[newX][newY] <= matrix[x][y]+1){
                    continue;
                }
                // Add pair into q and update value of matrix of new row and new col 
                q.add(new Pair<Integer, Integer>(newX, newY));
                matrix[newX][newY] = matrix[x][y]+1;
            }
            
        }
        return matrix;
    }
}