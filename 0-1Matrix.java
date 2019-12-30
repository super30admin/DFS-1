/*
Time Complexity: O(m*n)
Space Complexity: O(m*n)
Breadth first search : Push all the cells with a '0' into the queue and replace all 1's with infinity(or 9999 in this case)
*/

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if(matrix == null || m==0)
            return matrix;

        int n = matrix[0].length;

        int[][] dirs = new int[][] {{0,-1}, {0,1}, {-1,0}, {1,0}};
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0)
                    q.add(new int[]{i,j});
                else
                    matrix[i][j] = 9999;
            }
        }

        while(!q.isEmpty()){
            int size = q.size();

            for(int k=0; k<size; k++){
                int cur[] = q.poll();
                for(int[] dir: dirs){
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];

                    if(r>=0 && r<m && c>=0 && c<n && matrix[r][c] > matrix[cur[0]][cur[1]] + 1) {
                        q.add(new int[]{r,c});
                        matrix[r][c] = matrix[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }

        return matrix;
    }
}
