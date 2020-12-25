/** Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
* TC O(R*C). SC O(R*C)
*/
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return matrix;
        Queue<int []> dist = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i< m; i++) {
            for(int j = 0; j<n; j++) {
                if (matrix[i][j] == 0)
                {
                    dist.add(new int[] {i, j});
                }
                else 
                {
                    matrix[i][j] = -1;
                }
            }
        }
            int length = 0;
            int [][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
            while(!dist.isEmpty()) {
                int size = dist.size();
                length++;
                for (int i = 0; i < size; i++) {
                    int [] loc = dist.poll();
                    for (int k = 0; k< dirs.length; k++)
                    {
                        int r = loc[0] + dirs[k][0];
                        int c = loc[1] + dirs[k][1];
                        if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] == -1) {
                            dist.add(new int[] {r, c});
                            matrix[r][c] = length;
                        }
                    }
                }
            }
            return matrix;
        }      
    }

