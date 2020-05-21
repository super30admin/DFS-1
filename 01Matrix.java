// Time Complexity : O(n) where n is the number of elements in the matrix
// Space Complexity : O(n) BFS queue
// Did this code successfully run on Leetcode : Partial
// Any problem you faced while coding this :  Initially, I started with 1's and realised its going to the worse case
/* Your code here along with comments explaining your approach:  start with the  0's. Add the indices of the 0's to the queue and mark them visited.
We can optimise distances, by starting form 0 to a non 0 value in the matrix. As you process the pairs of 0 in the queue, find the non zero value using the
dirs array, and measure the distance, take the minimum distance out of all four directions. Keep a track of visited nodes to do it in place.
*/
//BFS
class Solution {
    class Pair{                                                                                     // coordinates matrix celll
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
     HashSet<Pair> visited = new HashSet<>();                                                   // todo in place
    for(int i = 0; i < matrix.length; i++){
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[i][j] == 0){
                visited.add(new Pair(i,j));                                         // visited the 0 marked cells
                q.add(new Pair(i,j));                                                   // Add 0 marked cells to the queue
            }
        }
    }
    bfs(matrix, q, visited);
    return matrix;
    }
     private void bfs(int[][] matrix, Queue<Pair> q, HashSet<Pair> visited){ 
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};                       // Neighbors check
        while(!q.isEmpty()){
        Pair fetch = q.poll();
        int i1 = fetch.getRow();
        int j1 = fetch.getCol();
        for(int[] dir: dirs){
            int r = i1 + dir[0];                                                            // move in directions
            int c = j1 + dir[1];
            Pair p = new Pair(r,c);
            if(!visited.contains(p)){                                                   // if unmarked cell => unvisited
            if(r >=0 && c >=0 && r<matrix.length && c <matrix[0].length){
                if(matrix[r][c] > matrix[i1][j1] + 1){                                      // if the distance of the unmarked cell is lesser 
                matrix[r][c] = matrix[i1][j1] + 1;                                                  // update the distance
                q.add(p);                                                                       // Add to queue as marked
                visited.add(p);                                                                 // Mark visited
                }
            }
        }
        }
        }
     }
}
