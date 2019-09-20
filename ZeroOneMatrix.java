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
 * TODO The below code contains bugs
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
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
        
        
        int[] x = new int[]{-1, 0, 1, 0};
        int[] y = new int[]{0, 1, 0, -1};
        while(!q.isEmpty()) {
            Pair current = q.remove();
            System.out.println("x: " + current.x + " y: " + current.y);
            for(int dx : x) {
                for(int dy : y) {
                    if(current.x + dx >= 0 && current.x + dx < m && current.y + dy >= 0 && current.y + dy < n) {
                        if(result[current.x][current.y] + 1 < result[current.x + dx][current.y + dy]) {
    result[current.x + dx][current.y + dy] = result[current.x][current.y] + 1;
                             q.add(new Pair(current.x + dx, current.y + dy));
                            
                        }
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