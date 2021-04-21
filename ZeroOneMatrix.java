
//Approach BFS
//Time Complexity - O(N) - where N is the total elements in matrix (row x col)
//Space Complexity - O(N) - where N is the total elements in matrix (row x col)
class Solution {
  public int[][] updateMatrix(int[][] matrix) {

    if(matrix == null || matrix.length == 0){
      return matrix;
    }

    int m = matrix.length;
    int n = matrix[0].length;

    Queue<int[]> queue = new LinkedList<>();
    int count = 0;

    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        if(matrix[i][j] == 0){
          queue.add(new int[]{i,j});
        }else{
          count++;
          matrix[i][j] = -1;
        }
      }
    }

    if(count == 0){
      return matrix;
    }
    int level = 1;

    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    while(!queue.isEmpty()){

      int size = queue.size();
      for(int i=0; i<size; i++){
        int[] coord = queue.poll();
        for(int[] dir: dirs){
          int r = coord[0]+dir[0];
          int c = coord[1]+dir[1];

          if(r >=0 && r<m && c>=0 && c<n && matrix[r][c] == -1){

            // System.out.println("here: "+coord[0]+" "+coord[1]+" rc: "+r+" "+c);

            matrix[r][c] = level;
            queue.add(new int[]{r,c});
          }
        }
      }
      level++;
    }

    return matrix;
  }
}