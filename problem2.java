 
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public int[][] updateMatrix(int[][] matrix) {
        
        if(matrix==null || matrix.length<=0){
            return new int[0][0];
        }
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        int[][] distance = new int[r][c];
        for(int i=0; i<r;i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
    
        int[] dirR = new int[]{1,-1,0,0};
        int[] dirC = new int[]{0,0,-1,1};
        
        Queue<Point> queue = new LinkedList<>();
     
        for(int i=0; i<r;i++){
            for(int j=0; j<c; j++){
                if(matrix[i][j]==0){
                    distance[i][j]=0;
                    queue.offer(new Point(i,j));
                }
            }
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size;i++){
                Point p = queue.poll();
                int x = p.x;
                int y = p.y;
                for(int j=0; j<4;j++){
                    int x_new = x + dirR[j];
                    int y_new = y + dirC[j];
                    if(x_new>=0 && x_new <r && y_new>=0 && y_new<c && distance[x_new][y_new]>distance[x][y]+1){
                        distance[x_new][y_new] = distance[x][y]+1;
                        queue.add(new Point(x_new,y_new));
                    }
                }
            }
        }
        
        return distance;
        
    }
}