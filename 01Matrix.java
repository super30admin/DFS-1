/*
- Approach1:
- BFS on 0's: Add all the zeros in the queue and process the neighbours level by level
- Iterate throught the mat to add 0's in the queue and at the same time if we encounter 1, change it to -1 because we want to keep track of visited 1's. Coz the distance can also be 1 so we dont want to get confused between whether the distance is 1 or the cell is not visited yet
- Keep a dist variable to track distance and increment on each level and as we want to do processing on a level order, we will need a size variable. 
- Check for bounds and update the cell by distance and add the processed cell in the queue.
TC: O(m*n) -> iterate through all the cells in the mat
SC: O(m*n) -> worst case, all the cells are zeros in the mat except 1
 */
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0,-1}, {-1,0}, {0,1}, {1,0}};
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0)
                    q.add(new int[]{i,j});

                else
                    mat[i][j] = -1;
            }
        }

        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && mat[r][c] == -1){
                        mat[r][c] = dist;
                        q.add(new int[]{r,c});
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}