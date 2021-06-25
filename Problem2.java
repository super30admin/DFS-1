
// Time - O( M*N)
// Space - O( M*N)



class Solution {
    public int[][] updateMatrix(int[][] mat) {

        if(mat == null || mat.length == 0 || mat[0].length == 0) return mat;

        Queue<int []> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;

        // Iterate through the queue array and add 0's to the queue and other elements in the matrix replace it by -1

        for( int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
                else {
                    mat[i][j] = -1;
                }

            }
        }

        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};


        // mark the distance as 1 in the first pass that will increment every level
        int dist = 1;
        while(!q.isEmpty()) {



            int size = q.size();

            // iterate through dirs array in 4 direction and mutate the elements with the dist value
            for (int i = 0; i < size; i++) {
                int [] curr = q.poll();


                for( int [] dir: dirs) {

                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];

                    if(r >= 0 && c >= 0 && r < m && c < n && mat[r][c] == -1) {

                        q.add(new int[] {r,c});
                        mat[r][c] = dist;


                    }


                }

            }

            dist++;

        }

        return mat;


    }
}