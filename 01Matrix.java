// Time Complexity : O(m*n).
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Approach : I implemented BFS to solve this problem. First we collect all zeros and add to queue so that we need to explore all neighboring 1's around
// that zeros. Also, we make 1's as -1 to differentiate the distance value. We explore the neighbours at each 0, level by level and assign that distance value
// to the matrix element and continue until we explore all zeroes i.e queue is empty.

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = mat.length;
        int n = mat[0].length;
        int dist = 1;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){ //adding 0's to queue
                    queue.add(new int[]{i,j});
                }else{
                    mat[i][j] = -1; //assign -1 to all 1's
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                for(int[] dir : directions){
                    int r = dir[0] + curr[0]; //neighbor rows
                    int c = dir[1] + curr[1]; //neighbor columns

                    if( r>= 0 && c>=0 && r<m && c<n && mat[r][c] == -1){ //bounds and condition check
                        queue.add(new int[]{r,c});
                        mat[r][c] = dist; //assign distance value
                    }
                }
            }
            dist++; //increment distance for each level traversal
        }

        return mat;
    }
}