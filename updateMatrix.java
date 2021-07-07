// Time Complexity :O(m*n) m is the length and n is breadth of the matrix
// Space Complexity :O(m*n) m is the length and n is breadth of the matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        Queue<int[]> q = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i,j});
                }
                else{
                    matrix[i][j] = -1;
                }
            }
        }
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i <size;i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int r = curr[0]+dir[0];
                    int c = curr[1]+dir[1];
                    if(r<m && r>=0 && c<n && c>=0 && matrix[r][c] == -1){
                        matrix[r][c] = dist;
                        q.add(new int[]{r,c});
                    }
                }
            }
            dist++;
        }
        return matrix;
        
    }
}