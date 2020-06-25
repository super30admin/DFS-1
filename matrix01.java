//Time Complexity:O(mn)
//Space Complexity:O(mn)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length==0 || matrix==null){
            return matrix;
        }
        Queue<int[]> q = new LinkedList();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    q.add(new int[] {i,j});
                }else{
                    matrix[i][j]=-1;
                }
            }
        }
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        int dist=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] arr=q.poll();
                for(int[] dir:dirs){
                    int r=dir[0]+arr[0];
                    int c=dir[1]+arr[1];
                    if(r>=0 && c>=0 && r<matrix.length && c<matrix[0].length && matrix[r][c]==-1){
                        q.add(new int[]{r,c});
                        matrix[r][c]=dist;
                    }
                }
            }
            dist++;
        }
        return matrix;
        
    }
}