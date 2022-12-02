//Time complexity is O(M*N)
//Space complexity is O(M*N)
class Solution {
    int[][] dirs = new int[][]{new int[]{-1, 0}, new int[]{0, -1}, new int[]{1, 0}, new int[]{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> qu = new LinkedList();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    qu.add(new int[]{i,j});
                }
                else{
                    result[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        while(!qu.isEmpty()){
            int[] arr= qu.poll();
            for(int[] dir: dirs){
                int i=dir[0]+arr[0];
                int j=dir[1]+arr[1];
                if(i<0 ||j<0 || i>=m || j>=n || result[i][j]<(result[arr[0]][arr[1]]+1)){
                    continue;
                }
                result[i][j]=result[arr[0]][arr[1]]+1;
                qu.add(new int[]{i,j});
            }
        }

        return result;
    }
}