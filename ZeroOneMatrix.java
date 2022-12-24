import java.util.*;
import java.util.LinkedList;

public class ZeroOneMatrix {
  // The key to this solution using BFS is that we have to put ALL 0 in a first level and thn keep adding all neihbouring 1 and keep on ibcreasing levels 
    
    int m;
    int n;
     int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        
         m = mat.length;
         n = mat[0].length;
        int level=1;
        
        Queue<int[]> queue = new LinkedList<>();
       
        // first level add all 0
        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(mat[i][j]==0)
                   queue.add(new int[]{i,j}); 
           }
        }
        
        while(!queue.isEmpty()){
            
         int length = queue.size();  
            
          for(int i=0;i<length;i++){
              int [] curr = queue.poll();
              int r = curr[0];
              int c = curr[1];
              for(int[] dir:dirs){
                  int nr = r+dir[0];
                  int nc = c+dir[1];
                  if(nr<0||nr==m||nc<0||nc==n || mat[nr][nc]<=0){
                      continue;
                  }
                  else{
                      mat[nr][nc] = level * -1;
                      queue.add(new int[]{nr,nc});
                  }
              }
          }  
            level++;
        }
     
        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(mat[i][j]<0){
                   mat[i][j] *=-1;
                   }
             }    
              
        }
        
        return mat;
    }
}
