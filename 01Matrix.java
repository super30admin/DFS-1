/* Time Complexity : O(M*N)
Space COmplexity : O(M*N)
Idea : U start with all 0's and put into queue becuase they decide
the distance to 1 else I have to do BFS from each 1 leading to time complexity
of M^2 * N^2.
*/
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = -1;
                }else{
                    queue.add(new int[]{i,j});
                }
            }
        }
        int dist = 1;
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                int[] curr = queue.poll();
                for(int[] dir : dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r>=0 && c>=0 && r<row && c<col && matrix[r][c] == -1){
                        matrix[r][c] = dist;
                        queue.add(new int[]{r,c});
                    } 
                }
                size--;
            }
           dist++;  
        }
        return matrix;
    }
}