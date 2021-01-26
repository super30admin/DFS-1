import java.util.*;

//Time com - o(mn)
//Space com - o(mn)
//Lettcode - Yes
public class Matrix01 {
	
public int[][] updateMatrix(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0) return matrix;
        
        int m = matrix.length, n = matrix[0].length;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                	//add all independent nodes in queue
                    q.add(i); q.add(j);
                } else{
                	//so we don't traverse the same node again
                    matrix[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty()) {
        	//no need size var bcs queue itself work as size
            int cr = q.poll();
            int cc = q.poll();
            // all 4 dirs
            int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
            for(int [] dir: dirs){
                int r = cr+dir[0];
                int c = cc+dir[1];
                //check conditions and add one to above distance 
                if(r>= 0 && c>= 0 && r<m && c<n && matrix[r][c] == -1){
                    matrix[r][c] = matrix[cr][cc] + 1;
                    q.add(r); q.add(c);
                }
            }
            
        }
        return matrix;
    }

}
