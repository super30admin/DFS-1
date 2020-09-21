    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/01-matrix/
    Time Complexity for operators : o(m*n) .. number of nodes in tree.
    Extra Space Complexity for operators : o(m*n) ... used queue
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach same like basic approach:
                              
            Approach :- 
                    A. We will use BFS here instead of DFS. DFS will work but it will fail when there is an infinite array.
                       there will never be an dead end for DFS. BFS will work perfect in that case.
                    B. We will start from 0's as 1's will take time more time. 0's will be little better that starting from 1's. 
                    C. First add all Zeros in to the queue for processing. and make 1 as Integer.MAX_VALUE.
                    D. We will process the queue data one by one and if all 4 directions are valid and 
                       the value of matrix[i][j]+1 < matrix[r][c] then only we will change the value of that matrix[r][c]
                       (r and c are newly cauclated directions)
                    E. Then, we will add that data into the Queue.
                    F. At the end, we will return matrix.

       */

class matrix01   {
    public int[][] updateMatrix(int[][] matrix) {
        
        if(matrix==null || matrix.length == 0 || matrix[0].length ==0)
            return matrix;
        
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 1)
                    matrix[i][j] = Integer.MAX_VALUE;
                else if(matrix[i][j] == 0)
                    queue.add(new int[]{i,j});
            }
        }
        
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!queue.isEmpty()){
            int[] front =  queue.poll();
            int i = front[0];
            int j = front[1];
            for(int[] dirs : directions){
                int r = i + dirs[0];
                int c = j + dirs[1];
                
                if(r>=0 && r< matrix.length && c >=0 && c< matrix[0].length && matrix[i][j]+1 < matrix[r][c]){
                    matrix[r][c] = matrix[i][j]+1;
                    queue.add(new int[]{r,c});
                }
            }
        }
        
        // runtime complexity = n*m
        //space complexity = n*m
        
        return matrix;
    }
}