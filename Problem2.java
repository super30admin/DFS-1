

//Time: O(m*n)
//Space :(m*n)
// Steps - Insert all the 0 elements into queue
// - and set others as -1 to show non visited elements
//- then take queuesize and then from every element go in 4 directions and update the length of that
// position from 0
//- then update the distance variable taken to keep track of distance


public class Problem2 {
	 public int[][] updateMatrix(int[][] matrix) {
	        if(matrix==null || matrix.length==0)
	            return matrix;
	        
	        Queue<int[]> q= new LinkedList<>();
	        int m = matrix.length;
	        int n = matrix[0].length;
	        
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                if(matrix[i][j]==0){
	                   q.add(new int[]{i,j});
	                }else{
	                    matrix[i][j]=-1;
	                }
	            }
	        }
	        
	        int dist=1;
	        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	        while(!q.isEmpty()){
	            int quesize=q.size();
	            
	            for(int i=0;i<quesize;i++){
	                int[] curr=q.poll();
	                
	                for(int[] d: dir){
	                    int r= curr[0]+d[0];
	                    int c= curr[1]+d[1];
	                    
	                    if(r>=0 && r<m && c>=0 && c<n && matrix[r][c]==-1){
	                        matrix[r][c]=dist;
	                        System.out.println(matrix[r][c]);
	                        q.add(new int[]{r,c});
	                    }
	                }
	                
	            }
	            dist++;
	        }
	        
	        return matrix;
	    }
	 
}
