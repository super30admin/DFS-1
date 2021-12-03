// 542 01 Matrix
// Solved on leetcode
// Time Complexity : O(n*m)
// space complexity: O(n*m)


class Solution {
    
    class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
        
        int getX(){
            return i;
        }
        int getY(){
            return j;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        
        int [] [] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<Pair> queue = new LinkedList();
        int directions=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    queue.offer(new Pair(i,j));
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                Pair curr= queue.poll();
                
                for(int [] view: dir){
                    int row= curr.getX()+ view[0];
                    int col = curr.getY() + view[1];
                    
                    if(row>=0 && row < mat.length && col>=0 && col<mat[0].length && mat[row][col]== -1 ){
                        queue.add(new Pair(row,col));
                        mat[row][col]= directions+1;
                    }
                }
                
            }
            directions +=1;
            
            
        }
        return mat;
    }
}