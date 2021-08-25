class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //Base case
        if(mat==null || mat.length ==0){
            return mat;
        }
        //Logic
        //We need to inititate BFS from all 0's and keep tracking next levels
        //Each level would be providing updated min distance from nearest 0
        //First level or level 0 -> would be all 0's so min dist=0
        //Next level/neighbors now-> would be +1 and so on.
        int m = mat.length;
        int n = mat[0].length;
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        //For initiating the BFS add all the 0's
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //We need to initiate at '0'
                if(mat[i][j]==0){
                    r.add(i);
                    c.add(j);
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int level = 1;
        //Now we need to traverse and update min distance for other values in mat
        while(!r.isEmpty()){
            int size = r.size();
            for(int i=0; i<size; i++){
                int row = r.poll();
                int col = c.poll();
                for(int[] dir: dirs){
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]==-1){
                        r.add(nr);
                        c.add(nc);
                        mat[nr][nc] = level;
                    }
                }
                
            }
            level++;
        }
        return mat;
    }
}