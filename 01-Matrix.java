//Time: O(m*n)
//Space: O(m*n) for the queue used in BFS, in the worst case where all cells are processed.

class Solution {

    Queue<int[]> q;
    int dirs[][];
    int m,n;

    public int[][] updateMatrix(int[][] mat) {

        this.q=new LinkedList<>();
        this.dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        this.m= mat.length;
        this.n= mat[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                }
                else {
                    mat[i][j] = -1;  //mark all 1's as -1 to avoid visiting again once distance updated
                }
            }
        }

        int dist=1;
        while(!q.isEmpty()){

            int size=q.size();

            for(int i=0;i<size;i++){

                int curr[]=q.poll();

                for(int dir[]:dirs){
                    int r=curr[0]+dir[0];
                    int c=curr[1]+dir[1];

                    if(r>=0 && r<m && c>=0 && c<n && mat[r][c] == -1){
                        q.add(new int[]{r,c});
                        mat[r][c]=dist;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}