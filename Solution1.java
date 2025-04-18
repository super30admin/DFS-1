//BFS
//State change

class Solution1 {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
                else{
                    mat[i][j] = -1;
                }

            }
        }
        if(queue.isEmpty()) return mat;
        int dist = 1;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            while (size > 0) {
                int[] temp = queue.poll();
                for(int[] direction : directions)
                {

                    int r = temp[0] + direction[0];
                    int c = temp[1] + direction[1];

                    if(r >= 0 && c >= 0 && r < m && c < n && mat[r][c] == -1)
                    {
                        queue.add(new int[]{r,c});
                        mat[r][c] = dist;

                    }

                }
                size--;
            }
            dist++;
        }
        return mat;

    }

}
