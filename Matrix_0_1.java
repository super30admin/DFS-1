/**

Time Complexity : O(m*n) 
Space complexity : O(m*n)
where m = number of rows
n = number of columns 
worked on leetcode : YES
**/

class Solution {
     class Node{
        int x;
        int y;
        Node(int x, int y){
          this.x = x;
          this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            System.out.println("called");
          if (this == o) return true;
          if (!(o instanceof Node)) return false;
          Node node = (Node) o;
          return x == node.x &&
                  y == node.y;
        }
        @Override
        public int hashCode() {
          return Objects.hash(x, y);
        }
  }

    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return matrix;
        }
        int dirs [][] = new int[ ][]{{0,1}, {1,0}, {0,-1}, {-1,0} }; 
        int [][] res = new int[matrix.length][matrix[0].length];
        Set<Node> set = new HashSet();
        Queue<Node> q = new LinkedList();
        for(int i  =0;i < matrix.length; i++) {
            for(int j = 0; j< matrix[0].length; j++) {
                
                if(matrix[i][j] == 0) {
                    Node n = new Node(i, j);
                    q.add(n);
                    
                }else{
                    matrix[i][j ] = -1;
                }
               
            }
        }
     
       
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            // traverse level by level
            // we already put zero in queue so each level we will increase distance by 1 to all nearst 1's 
            // we wil udpate the distance for ones level by level 
            
            while(size -- > 0) {
                Node loc = q.poll();
                int x = loc.x;
                int y = loc.y;

                for(int [] dir: dirs) {
                    int x1 = dir[0];
                    int y1= dir[1];
                    int r = x1+x;
                    int c = y1+y;

                    if(r >=0 && r < matrix.length && c  >= 0  && c < matrix[0].length && matrix[r][c] == -1) {
                        matrix[r][c] = level;
                        Node newLoc = new Node(r,c);
                        q.add(newLoc);  
                    }
                
                }  
            
            }
            
            
            level++;
            
            
            }
        
        
        return matrix;
    }
}
