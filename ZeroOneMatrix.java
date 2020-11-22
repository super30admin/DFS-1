/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * 
 * Idea:
 * Use breadth first search on the zeroes, start off by having a result grid initialized to +inf at each cell;
 * then add all the locations where we have 0 value to the queue.
 * 
 * Then in breadth first manner, try visiting the 4 neighbouts and update its distance.
 * 
 * Space Complexity: O(mn)
 * Time Complexity: O(mn)
 * 
 * Leetcode Result:
 * Runtime: 17 ms, faster than 52.24% of Java online submissions for 01 Matrix.
 * Memory Usage: 54.3 MB, less than 95.83% of Java online submissions for 01 Matrix.
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m==0) return matrix;
        int n = matrix[0].length;
        int[][] result = new int[m][n];
        
        // fill all zeroes in queue
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = Integer.MAX_VALUE;
                if(matrix[i][j] == 0) {
                    q.add(new Pair(i, j));
                    result[i][j] = 0;
                }
            }
        }
        
        
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        while(!q.isEmpty()) {
            Pair current = q.remove();
            for(int i = 0; i< 4; i++) {
                int x = current.x + dx[i];
                int y = current.y + dy[i];
                
                if(x >= 0 && x < m && y >= 0 && y < n) {
                    if(result[current.x][current.y] + 1 < result[x][y]) {
                        result[x][y] = result[current.x][current.y] + 1;
                        q.add(new Pair(x, y));

                    }
                }
            }
        }
        
        return result;
    }
}

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}