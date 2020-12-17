// Time Complexity :O(m*n) 
// Space Complexity :O(m*n) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach:Storing all the cordinates of 0 in queue and marking them as visited. 
// Then we do BFS . Pop each cordinates in the queue and check if their neighbours are not visited, then add them to the queue and update
// the level in the result matrix of that cordinates.
class Solution {
    int[][] result;
    public int[][] updateMatrix(int[][] matrix) {
        result=new int[matrix.length][matrix[0].length];
        
        int[][] visited=new int[matrix.length][matrix[0].length];
        int dir[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0 ){                    
                queue.add(new int[]{i,j});
                        visited[i][j]=1;
                }
            }
        }
        int level=1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int l=0; l< size;l++){
                int i= queue.peek()[0];
                int j=queue.poll()[1];
                //System.out.println(i+"i j"+j);
                for(int d[] : dir){
                    int x= i+d[0];
                    int y= j+d[1];
                    if(x <0 || y <0 || x>=matrix.length || y>= matrix[0].length || matrix[x][y]==0 || visited[x][y]==1)
                        continue;
            
                //System.out.println(i+"i j"+j);
                    if(matrix[x][y] != 0){
                        
                //System.out.println(i+"i j"+j  +"   level "+level);
                        visited[x][y]=1;
                        result[x][y]=level;
                        queue.add(new int[]{x,y});
                        
                    }
            }
                
        }
            level++;
        }
       return result;
    }
}