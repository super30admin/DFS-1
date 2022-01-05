// Time Complexity : O(M * N)
// Space Complexity :O(M * N) due to queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * Here we use BFS approach as we need to process all elements which are at same level at the same time
 * Since 0 is independant, we put all 0s in queue at begining and make all 1s as -1 to make them unvisited
 * Now for each level, we pop from queue and check all directions of current cell.
 * We get an unvisited element we put the value of level that we are processing currently starting with 1.
 * All processed element we put in queue to check their neibours
 * The negative value at neibouring cell ( -1 to be specific) indicated that, this neibour is unvisited.
*/


class Solution {
    
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0)return mat;
        Queue<int[]> q = new LinkedList();
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for(int r = 0; r < mat.length;r++){
            for(int c = 0; c < mat[0].length;c++){
                if(mat[r][c] == 0){
                    q.add(new int[]{r,c});
                }else{
                    mat[r][c] = -1;
                }
            }
        }
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size;i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length){
                        if(mat[nr][nc] < 0){
                            mat[nr][nc] = level;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }    
            }
            level++;
        }
        
        return mat;
    }
}