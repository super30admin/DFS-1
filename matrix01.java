package trees;

import java.util.LinkedList;
import java.util.Queue;

public class matrix01 {
	  public int[][] updateMatrix(int[][] matrix) {
	        if(matrix == null || matrix.length ==0){
	            return matrix;
	        }
	       int m = matrix.length;
	       int n=matrix[0].length;
	        Queue<int[]> q= new LinkedList<>();
	        
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                if(matrix[i][j]==0){
	                    q.offer(new int[]{i,j});
	                   
	                }
	                else{
	                    matrix[i][j]=-1;
	                }
	            }
	        }
	        final int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
	        int dist=1;
	        while(!q.isEmpty()){
	            int size=q.size();
	            for(int i=0;i<size;i++){
	                int[] curr=q.poll();
	                for(int[] dir:direction){
	                    int x = curr[0] + dir[0];
	                    int y = curr[1]+ dir[1];
	                    if(x>=0 && x<m && y>=0 && y<n && matrix[x][y]==-1){
	                       matrix[x][y] = dist;
	                        q.add(new int[]{x,y});
	                    }
	                   
	                }
	            }
	            dist++;
	        }
	        return matrix;
	    }

}

//t=O(mn)
//s=O(mn)