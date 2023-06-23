//Optimal Solution: BFS  , keep all the zero's in a queue and find the indecises connected with
// them and if they are equal to 1, add them to the queue and modify the value with distance(level in bfs).

//Time complexity: O(M*N)
//Space Complexity: O(M*N)

//It's working well in Leetcode but can you please check the base case. Thanks
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

        //base
        if(mat == null || mat.length == 0) return null;

        int m = mat.length;
        int n = mat[0].length;

        //putting 0's in queue
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for (int j = 0; j < n ; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }else if(mat[i][j] == 1){
                    mat[i][j] = -1;
                }
            }
        }

        int distance = 1;
        while(!q.isEmpty()){

            int size = q.size();
            for(int i =0; i<size ; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if( nc >= 0 && nr >= 0 && nr < m && nc < n && mat[nr][nc] == -1){
                        q.add(new int[]{nr,nc});
                        mat[nr][nc] = distance;

                    }
                }

            }
            distance++;
        }

        return mat;
    }
}