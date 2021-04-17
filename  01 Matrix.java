//BFS
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
//m is the number of rows and n is the number of cols
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return matrix;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int count=0;//maintain a count of one's
        //use a queue to perform a bfs
        Queue<int[]> q = new LinkedList<>();
        //add all the zero loctoions into the queue and negate the one's
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else{
                    matrix[i][j] = -1;
                    //negating the values and later unnegating to indicate that this particular node is visited
                    count++;
                }
            }
        }
        //if all the cells had zero's then there is nothing left to chnage
        if(count==0){
            return matrix;
        }
        //start the bfs
        while(!q.isEmpty()){
            //determine the neighbouring nodes
                 int cur[] = q.poll();
                //direction array to find the four cornors
                int dirs[][] = {{0,-1},{1,0},{0,1},{-1,0}};
                for(int dir[] : dirs){
                   int row = cur[0] + dir[0];
                   int col = cur[1] + dir[1]; 
                   if(row>=0 && row<r && col>=0 && col<c && matrix[row][col]==-1){
                       matrix[row][col] = matrix[cur[0]][cur[1]]+1;
                       q.add(new int[]{row,col});
                   }
                }
            }
        return matrix;
    }
}