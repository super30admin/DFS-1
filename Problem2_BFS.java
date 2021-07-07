/**
LeetCode Submitted : YES
Space Complexity : O(M*N)
Time Complexity : O(M*N)

The idea is to use to Queue to traverse the matrix in BFS fashion. We initially put all zero nodes to the Queue and update all 1 nodes to MAX distance. Then we update the distance of the non-zero nodes such that it is Min(matrix[new_node_i][new_node_j],matrix[process_node_i][process_node_j] + 1) 

**/
class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}}; 
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return matrix;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        //Add zero nodes in the Queue
        Queue<int[]> q = new LinkedList<>();
        
        //Preprocess the matrix 
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                if(matrix[i][j] == 0){ //Add zero nodes to the Queue
                    q.add(new int[]{i,j});
                }else{
                    matrix[i][j] = Integer.MAX_VALUE; //Update non zero nodes to max distance
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] currNode = q.poll();
            
            for(int[] dir : dirs){
                int row = currNode[0] + dir[0];
                int col = currNode[1] + dir[1];
                
                if(row >= 0 && row < m && col >= 0 && col < n){
                    if(matrix[row][col] > matrix[currNode[0]][currNode[1]] + 1){ //Djikstras shortest path route across each nodes
                        matrix[row][col] = matrix[currNode[0]][currNode[1]] + 1;
                        q.add(new int[]{row,col});
                    }
                }
            }
        }
        
        return matrix;
    }
}
