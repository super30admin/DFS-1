// Time Complexity - O(m * n)
// Space Compleixty - O(m * n)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int distance = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.add(i);
                    q.add(j);
                }
                if(mat[i][j] == 1){
                    mat[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i+=2){
                int currR = q.poll();
                int currC = q.poll();

                if(mat[currR][currC] != 0){
                    if(mat[currR][currC] == -1){
                        mat[currR][currC] = distance;
                    }else{
                        mat[currR][currC] = Math.min(mat[currR][currC], distance);
                    }
                }
                int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
                for(int[] dirs : dir){
                    int r = currR + dirs[0];
                    int c = currC + dirs[1];
                    if(r < 0 || r >= rows || c < 0 || c >= cols || mat[r][c] == 0 || mat[r][c] != -1){
                        continue;
                    }
                    q.add(r);
                    q.add(c);
                }
            }
            distance++;
        }
        return mat;
    }
}
