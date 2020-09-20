class Solution {
    public int[][] updateMatrix(int[][] grid) {
        
        Queue<Pair<Integer, Integer>>q = new LinkedList();
        //int fresh = 0;
        for(int i = 0; i < grid.length;i++){
             for(int j = 0; j < grid[0].length;j++){
                 if(grid[i][j] == 0){
                     q.add(new Pair(i, j));
                 }
                 else if(grid[i][j] == 1){
                     grid[i][j] = -1;
                 }
                
        }
        }
        
        //int mins = 0;
            
            int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};
            
            while(!q.isEmpty()){
                //if(fresh == 0) return mins;
                
                //mins++;
                int qsize = q.size();
                for(int i =0;i < qsize;i++){
                    Pair<Integer, Integer> p = q.poll();
                    int r1 = p.getKey();
                    int c1 = p.getValue();
                    for(int[] d : dir){
                        int r =r1 + d[0];
                    int c = c1 + d[1];
                        //System.out.println(r+ " "+c);
                    if(r >=0 && r < grid.length &&c >=0 && c < grid[0].length && grid[r][c]==-1 ){
                        
                        
                        grid[r][c]=grid[r1][c1] + 1;
                        q.add(new Pair(r, c));
                        
                        //fresh--;
                    }
                    }
                }
            }
        //if(fresh > 0) return -1;
        return grid;
        
    }
}