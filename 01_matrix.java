class Solution{
    public int[][] updateMatrix(int[][] mat){
       if(mat == null || mat.length == 0) return mat; // if the matrix is not having any elements or the length of the matrix is 0, we simply return the matrix.
       int m = mat.length; // m is the no. of rows in the matrix
       int n = mat[0].length; // n is the no. of cols in the matrix
       Queue<int[]> q = new LinkedList<>(); // we initialize a queue which stores the location of elements
       int[][] dirs = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}} // we initialize a 2d array with name dirs which has the location of the surroundings that are to be visited
       for(int i = 0; i < m; i++){ // we go through each element in the row
           for(int j = 0; j < n; j++){ // we go through each element in the col
               if(mat[i][j] == 0){ // if the current location of the matrix is having a value as 0
                   q.add(new int[]{i,j}); // we add that particular location to the queue
               }
               else if(mat[i][j] == 1){ // if the current location of the matrix is having a value as 1
                   mat[i][j] = -1; // we convert the value 1 to -1 to avoid overlapping of the elements.
               }
           }
       }
       int lvl = 1; // to store the distances of the location of 0 from the current element, since we already had an iteration for 0's. we initialize the lvl to 1.
       while(!q.isEmpty()){ // here the q is anyway not empty. if the q is not empty
           int size = q.size(); // we check the size of the queue and store it in the integer variable size.
           for(int i = 0; i < size; i++){ // we go through every element in the queue.
               int[] curr = q.poll(); // as the queue is not empty, we pop the first element and store it in an integer array called as curr.
               for(int[] dir : dirs){ // now for the curr location, we check through the surroundings.
                   int nr = curr[0] + dir[0]; //we compute the new row.
                   int nc = curr[1] + dir[1]; // we compute the new col.
                   if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){ // if the new row and cols are greater than 0 and less than the length of rows and cols, and if that matrix is having a value as -1
                       mat[nr][nc] = 1; // we change it to 1.
                       q.add(new int[]{nr,nc}); // we add that new row and col to the q.
                   }
               }
           }
           lvl++ // we increment the lvl
       }
       return mat; // in the end, we return the matrix.
    }
}
//tc and sc - O(m*n )