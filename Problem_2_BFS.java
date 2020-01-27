/*
 * Time Complexity : O(m*n)
 * Space Complexity : O(m*n)
 * 
 */
import java.util.LinkedList;
import java.util.Queue;

public class Problem_2_BFS {
public int[][] updateMatrix(int[][] matrix) {
        
        int distance = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        int[][] dist = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            distance++;
            
            for(int i=0; i<size; i++){
                int[] ele = queue.poll();
                
                for(int[] dir : dist){
                    int r = dir[0] + ele[0];
                    int c = dir[1] + ele[1];
                    
                    if(r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && 
                       matrix[r][c] == 1){
                        matrix[r][c] = (-1) * distance;
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                matrix[i][j] = (-1) * matrix[i][j];
            }
        }
        
        return matrix;
        
    }
}
