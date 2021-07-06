//Leetcode : 542. 01 Matrix
//Time Complexity: O(n) , as we are iterating over all the elements of the matrix so its m X n.
//Space Complexity: O(n) , used queue 
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length ==0 || matrix[0].length==0) return matrix;
        int row= matrix.length;
        int col = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<row ;i++){
            for(int j=0; j<col ;j++){
                if(matrix[i][j]==0){
                    q.add(new int[] {i,j});
                }
                else{
                    matrix[i][j]=-1;
                }
            }
        }    
        int[][] dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
        int dist=0;
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            while(size>0){
                int[] ar= q.poll();
                int x;
                int y;
                for(int[] dir : dirs){
                    x = ar[0]+dir[0];
                    y = ar[1]+dir[1];
                
                if(x>=0 && x<row && y>=0 && y<col && matrix[x][y]==-1){
                    matrix[x][y] = dist;
                    q.add(new int[] {x,y});
                }
                }
                size--;
        }
            
        }
        return matrix;
    }
}