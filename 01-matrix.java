// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:here BFS approach first i put all the zeros in the queue and by polling them adding next adjacents to them as well as incrementing distance of their by one because each elevel the distance from zero will be incrementing.finally i am able to get distance matrix.
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<Integer> q1=new LinkedList<>();
         Queue<Integer> q2=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    q1.add(i);
                    q2.add(j);
                 
                }else{
                    mat[i][j]=-1;
                }
        }
        }
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        int distance=1;
        while(!q1.isEmpty()){
            int size=q1.size();
            for(int i=0;i<size;i++){
           int cr=q1.poll(); 
             int cc=q2.poll();
             for(int[] dir:dirs){
                int nr=cr+dir[0];
                int nc=cc+dir[1];
                 if(nr >= 0 && nr < m && nc >=0 && nc<n && mat[nr][nc] == -1 ){
                   q1.add(nr);
                  q2.add(nc);
                  mat[nr][nc] = distance;
                 }
                
             }   
            }
            distance++;
                       
        }
        return mat;           
    }
}


// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:here same as above approach but the difference is i am not using any distance or size ,because for every next element the distance would current+1 because we are considering 0 first.
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<Integer> q1=new LinkedList<>();
         Queue<Integer> q2=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    q1.add(i);
                    q2.add(j);
                 
                }else{
                    mat[i][j]=-1;
                }
        }
        }
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q1.isEmpty()){
             int cr=q1.poll(); 
             int cc=q2.poll();
             for(int[] dir:dirs){
                int nr=cr+dir[0];
                int nc=cc+dir[1];
                 if(nr >= 0 && nr < m && nc >=0 && nc<n && mat[nr][nc] == -1 ){
                   q1.add(nr);
                  q2.add(nc);
                  mat[nr][nc] = mat[cr][cc]+1;
             }   
            }
                       
        }
        return mat;           
    }
}