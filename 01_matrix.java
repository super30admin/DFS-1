//TimeComplexity:O(m*n)
//SpaceComplexity: O(m*n)
class Solution {
    int [][]dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        Queue<int []> queue = new LinkedList<>();
        for(int i =0; i<mat.length;i++) {
            for(int j=0; j<mat[0].length;j++) {
                if(mat[i][j] == 0) {
                    queue.add(new int[] {i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int distance = 1;
        while(!queue.isEmpty()) {
           int size = queue.size();
           for(int i =0; i<size;i++) {

               int []current = queue.poll();
               for(int []dir : dirs) {
                   int r = current[0]+dir[0];
                   int c=current[1]+dir[1];
                   if(r >=0 && c>=0 && r<mat.length && c <mat[0].length && mat[r][c] == -1) {
                       mat[r][c] = distance;
                       queue.add(new int[]{r,c});
                   }
               }
           }
           distance++;
        }
        return mat;
    }
}