// Time Complexity : O(n*m)
// Space Complexity : O(max of n,m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.LinkedList;
import java.util.Queue;

public class matrix_01 {
	 class Pair{
	        int X;
	        int Y;
	        
	        Pair(int X, int Y){
	            this.X=X;
	            this.Y=Y;
	        }
	    
	    }
	 
	    public int[][] updateMatrix(int[][] mat) {
	        Queue<Pair> queue=new LinkedList<>();
	        for(int i=0;i<mat.length;i++){
	            for(int j=0;j<mat[0].length;j++){
	                if(mat[i][j]==0){
	                    queue.add(new Pair(i,j));
	                }else{
	                    mat[i][j]=-1;
	                }
	            }
	        }
	        
	        int distance=0;
	        while(!queue.isEmpty()){
	            int size=queue.size();
	            for(int i=0;i<size;i++){
	                Pair curr=queue.poll();
	                int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
	                for(int[] dir:dirs){
	                    int row=curr.X+dir[0];
	                    int col=curr.Y+dir[1];
	                    if(row>=0 && row<mat.length && col>=0 && col<mat[0].length && mat[row][col]==-1){
	                        queue.add(new Pair(row,col));
	                        mat[row][col]=distance+1;
	                    }
	                }
	            }
	                 distance++;
	        }
	        return mat;
	   
	    }
	    
}
