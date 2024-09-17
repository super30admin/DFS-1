class Solution {
    int row, col;
    private class Pair{
    int x;
    int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int[][] updateMatrix(int[][] matrix) {  
        //edge case
        if(matrix == null || matrix.length == 0)
            return matrix;
        
        int distance =100;
        Queue<Pair> q = new LinkedList<>();
        row = matrix.length;
        col = matrix[0].length;
        //put all zeros in the queue. as there is no dependencies on zeros, we would be starting from all 0s
        for(int i=0;i< row;i++){
            for(int j=0;j< col;j++){
                if(matrix[i][j]==0){
                    matrix[i][j] = distance;
                    q.add(new Pair(i,j));
                }
            }
        }
        int [][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
        distance++;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                Pair p = q.remove();
                for(int []dir :dirs){
                    int newX = p.x + dir[0];
                    int newY = p.y + dir[1];
                    if(isValidIndex(newX, newY) && matrix[newX][newY] < 100){
                        matrix[newX][newY] = distance;
                        q.add(new Pair(newX, newY));
                    }
                }
            }
            distance++;
        }
        //updating the distance again.
        for(int i=0;i< row;i++){
            for(int j=0;j< col;j++){
                matrix[i][j] -= 100;
            }
        }
        
        return matrix;
    }
    private boolean isValidIndex(int x, int y){
        return x>=0 && x< row && y>=0 && y< col;
    }
}


