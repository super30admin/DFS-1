//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

// In this approach we go over the matrix initially and change all the values of 1 to a different number. Then we find the distance of the nearest 0
//using BFS and set the value at an index equal to the distance from the nearest 0.
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        Queue <int []> q = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j]== 0){
                    q.add(new int []{i,j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }
        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] curr = q.poll();
                for(int [] dir: dirs){
                    int rr = curr[0] + dir[0];
                    int rc = curr[1] + dir[1];
                    if(rr>=0 && rc >=0 && rr<m && rc<n && matrix[rr][rc]==-1){
                        q.add(new int []{rr, rc});
                        matrix[rr][rc] = dist;
                    }
                }
            }dist++;
        }return matrix;
        
        
    }
}