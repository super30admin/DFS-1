import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
public class ZeroOneMatrix {
	/**Approach: Optimized BFS **/
	public int[][] updateMatrix(int[][] mat) {
		if(mat==null) return mat;
		
        int m=mat.length;
        int n= mat[0].length;
        int[][] dirs= new int[][] {{0,1},{1,0},{0,-1},{-1,0}};//right,down,left,up
        boolean[][] visited= new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();                
        //Process all independent nodes first i.e. add all zeros to queue
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                    q.add(new int[] {i,j});
                    visited[i][j]=true;
                }
            }
        }        
        //Process other nodes to find distance from zero
        while(!q.isEmpty()){
            int[] curr=q.poll();
            for(int[] dir: dirs){
                int r= curr[0]+dir[0];
                int c= curr[1]+dir[1];
                
                if(r>=0 && c>=0 && r<m && c<n && !visited[r][c]){
                    if(mat[r][c]==1){
                        mat[r][c]= mat[curr[0]][curr[1]]+1;
                        visited[r][c]= true;
                    }
                    q.add(new int[] {r,c});
                }
            }
        }
        return mat;
    }

	// Driver code to test above 
	public static void main (String[] args) {
		ZeroOneMatrix ob= new ZeroOneMatrix();
		int[][] matrix= {{0,0,0},{0,1,0},{1,1,1}};
		
		int[][] dist= ob.updateMatrix(matrix);		
		System.out.println("Distance of nearest 0 : ");	
		for(int i=0; i<dist.length; i++) {
			System.out.println(Arrays.toString(dist[i]));
		}
	}
}
