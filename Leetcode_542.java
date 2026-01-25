//BFS: Place all 0's in queue
//Make all 1's to -1 to avoid confusion while comparing[Because first nearest 1 to immediate 0's 1]
//Travel till queue becomes empty. For every travel, do it as level order as time is increased by 1 for every level
//TC: 2(m*n) - 2 is const. So, O(m*n); SC:O(m*n)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    queue.add(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }

        int time=1;
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!(queue.isEmpty())){
            int size=queue.size();

            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                for(int[] d:dir){
                    int r=curr[0]+d[0];
                    int c=curr[1]+d[1];

                    if((r>=0 && r<m) && (c>=0 && c<n)){
                        if(mat[r][c]==-1){
                            mat[r][c]=time;
                            queue.add(new int[]{r,c});
                        }
                    }
                }
            }

            time+=1;
            
        }

    return mat;    
    }
}
