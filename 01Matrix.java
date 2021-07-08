// Time Complexity : O(n) where n is the number of elements in the matrix
// Space Complexity : O(n) BFS queue can maintain maximum n neighbors at a level
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  Initially, I started with 1's and realised its going to the worse case
/* Your code here along with comments explaining your approach:  start with the  0's. Add the indices of the 0's to the queue and mark them visited.
We can optimise distances, by starting form 0 to a non 0 value in the matrix. Mark the 1's as -1's or any arbitary number to avoid processing them into the
queue again because its the BFS nature that might allow repetations in the queue. As you process the pairs of 0 in the queue, find the non zero value using the
dirs array, and measure the distance by adding a 1 unit. Keep a track of visited nodes to do it in place.
*/
//BFS
class Solution {
    class Pair{                                                                 // Matrix cells of rows and column pairs
        int row;
        int col;
        Pair(int r, int c){
            this.row = r;
            this.col = c;
        }
        public int getRow(){return this.row;}
        public int getCol(){return this.col;}
    }
    public int[][] updateMatrix(int[][] matrix) {
     if(matrix == null || matrix.length == 0){return matrix;}
     Queue<Pair> q = new LinkedList<>();
     HashSet<Pair> visited = new HashSet<>();                                   // Mark the visited pairs
    for(int i = 0; i < matrix.length; i++){
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[i][j] == 0){
                visited.add(new Pair(i,j));                                 // Let's process the 0's first since they are independent of distance
                q.add(new Pair(i,j));
            } else {
                matrix[i][j] = -1;                                          // Mark the 1's as -1's to avoid repetitions in the queue
            }
        }
    }
    bfs(matrix, q, visited);                                                // Get Ready for BFS
    return matrix;
    }
     private void bfs(int[][] matrix, Queue<Pair> q, HashSet<Pair> visited){ 
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        while(!q.isEmpty()){
        Pair fetch = q.poll();                                                  // Fetch the pairs
        int i1 = fetch.getRow();
        int j1 = fetch.getCol();
        for(int[] dir: dirs){
            int r = i1 + dir[0];
            int c = j1 + dir[1];
            Pair p = new Pair(r,c);
            if(!visited.contains(p)){                                                               // if the pair has not been visited yet
            if(r >=0 && c >=0 && r<matrix.length && c <matrix[0].length && matrix[r][c]==-1){           // If the neighbor is a -1
                matrix[r][c] = matrix[i1][j1] + 1;                                          // Add it to the distance since its a non 0 and update the distance of the new cell where I am reaching
                q.add(p);
                visited.add(p);                                                         // Marked the cell visited and add it to the queue
            }
        }
        }
        }
     }
}
