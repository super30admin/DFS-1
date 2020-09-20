// Time Complexity : O(m*n) where m and n are number of cols and rows 
// Space Complexity : O(h) where h is the height of the tree `O(m*n) as entire matrix can be 0 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// alternate answers
// finding 1s and then searching for neighbouring 0s will give is tc as O(m2 n2)
// do dfs by masking current cell if it has 1, but still duplicate computation is required

/*


instead we go for an iterative approach (dp +bfs)
Here we first turn the 1s to -1s(to separate newly converted 1s from already present 1s) and add the (x,y) of 0s to the queue
which means that all the 0s are explored and as soon as -1 is seen as the neighbouring element for this 0s we update the dist and add this to the Queue
we are not concerned if cell value is 0 as it has already been added and all the old 1s are now -1s
so intially we have only 0s and -1s

we increment level at each level(while loop)
for all the elements which are neighbour to x we see if its inside boundary and the value is equal to -1 then
we update the value at the neighbouring cell (where we found -1) to the value at [original cell]+1,
also we add this to the queue to explore
if we encounter 1 we dont add it to queue since it has already been explored and to avoid computing again


*/

class Solution {
    public int[][] updateMatrix(int[][] matrix) {

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1)
                    matrix[i][j] = -1;
                else
                    q.offer(new int[] { i, j });
            }
        }

        int level = 1;
        int dirs[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                int temp[] = q.poll();

                for (int dir[] : dirs) {
                    int r = dir[0] + temp[0];
                    int c = dir[1] + temp[1];
                    if (r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length && matrix[r][c] == -1) {
                        // here instead of creating a level variable and updating this to matrix[r][c]
                        // matrix[r][c] = level;
                        // we can do it as
                        matrix[r][c] = matrix[temp[0]][temp[1]] + 1;
                        q.offer(new int[] { r, c });
                    }

                }
            }
            // level++;
        }

        return matrix;
    }
}