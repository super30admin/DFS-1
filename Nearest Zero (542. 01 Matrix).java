// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {

    public int[][] updateMatrix(int[][] mat) {
        
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = -1;
                } else {
                    // Add only 0s that touch at least a single 1
                    boolean eligible = false;
                    if(i > 0 && mat[i-1][j] != 0) eligible = true;
                    if(i < mat.length-1 && mat[i+1][j] != 0) eligible = true;
                    if(j > 0 &&  mat[i][j-1] != 0) eligible = true;
                    if(j < mat[i].length - 1 && mat[i][j+1] != 0) eligible = true;
                    if(eligible) q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] coords = q.poll();
            int i = coords[0];
            int j = coords[1];
            if(i > 0 && mat[i-1][j] == -1) {
                mat[i-1][j] = mat[i][j]+1;
                q.offer(new int[]{i-1,j});
            }
            if(i < mat.length-1 && mat[i+1][j] == -1) {
                mat[i+1][j] = mat[i][j]+1;
                q.offer(new int[]{i+1,j});
            }
            if(j > 0 &&  mat[i][j-1] == -1) {
                mat[i][j-1] = mat[i][j]+1;
                q.offer(new int[]{i,j-1});
            }
            if(j < mat[i].length - 1 && mat[i][j+1] == -1) {
                mat[i][j+1] = mat[i][j]+1;
                q.offer(new int[]{i,j+1});
            }
        }

        return mat;

    }
}
