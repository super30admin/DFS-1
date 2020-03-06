// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve before class


// Your code here along with comments explaining your approach
//bfs
class Solution {
    
    //arrays to traverse the matrix 4-directionally
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    
    public int[][] updateMatrix(int[][] matrix) {
        
        //base checks
        int m = matrix.length;
        if(m==0) return matrix;
        int n = matrix[0].length;
        
        //initialze result matrix
        int[][] result = new int[m][n];
        
        // initialize queue to store the pair containing row, col value
        Queue<Pair> q = new LinkedList<>();
        
        //fill all zeroes in queue
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = Integer.MAX_VALUE;
                if(matrix[i][j] == 0) {
                    q.add(new Pair(i, j));
                    result[i][j] = 0;
                }
            }
        }
        
        
        
        while(!q.isEmpty()) {
            Pair current = q.poll();
            for(int i = 0; i< 4; i++) {
                int x = current.x + dx[i];
                int y = current.y + dy[i];
                
                //boudary check
                if(x >= 0 && x < m && y >= 0 && y < n) {
                	//if current+1 has value less than neighbour, then exchange value with current + 1
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