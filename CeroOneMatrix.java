// Time Complexity : O(NxM)N=number of rows in matrix and M number of columns in matrix . 
// Space Complexity : /O(maxDepth) for space, O(n/2) then O(N);
// and the worse case is all oranges are rotten.
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code uses the BFS traversal and we only enqueue when value is 0, and change to max integer when value is 1.
//Success
//Details 
//Runtime: 28 ms, faster than 16.49% of Java online submissions for 01 Matrix.
//Memory Usage: 90.8 MB, less than 8.33% of Java online submissions for 01 Matrix.

//O(NxM) for time
    //O(maxDepth) for space, O(n/2) then O(N);
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix==null || matrix.length<=0||matrix[0].length<0)
            return matrix;
        int n=matrix.length;
        int m=matrix[0].length;
        Queue<int[]> queue= new LinkedList<>();
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (matrix[i][j]==1){
                    matrix[i][j]=Integer.MAX_VALUE;
                }else{
                    queue.add(new int[]{i,j});
                }
            }
        }
       int [][] directions= {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                int[] root=queue.poll();
                
                int i_root=root[0];
                int j_root=root[1];
                for (int[] direction:directions){
                    int r= direction[0]+i_root;
                    int c= direction[1]+j_root;
                    
                    if (r>=0 && r<n && c>=0 && c<m && (matrix[i_root][j_root]+1<matrix[r][c])){
                        queue.add(new int[]{r,c});
                        matrix[r][c]=matrix[i_root][j_root]+1;
                        
                    }
                }
                
            }
        }
        return matrix;
    }
