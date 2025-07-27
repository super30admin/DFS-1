// BFS to find the distance to nearest 0
// TC: O(n)
// SC: O(n)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
                else{
                    mat[i][j] = mat[i][j] * -1;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(queue.size()>0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] node = queue.remove();
                for(int[] dir:dirs){
                    int nr = node[0] + dir[0];
                    int nc = node[1] + dir[1];
                    if(nr >=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]==-1){
                        mat[nr][nc] = mat[node[0]][node[1]] + 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return mat;
    }
}
