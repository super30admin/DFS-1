// time: O(n)
// space: O(n)
class Solution {
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0) return matrix;
        int n=matrix.length;
        int m=matrix[0].length;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0) queue.add(new int[]{i,j});
            }
        }
        // we need to find 0 , then add 1 to its neighbour and so on
        int level=1;
        while(!queue.isEmpty())
        {
            int nn=queue.size();
            for(int i=0;i<nn;i++)
            {
                int[] arr=queue.poll();
                for(int[] dir: dirs)
                {
                    int r=arr[0]+dir[0];
                    int c=arr[1]+dir[1];
                    if(r>=0 && r<n && c>=0 && c<m && matrix[r][c]==1) {
                        matrix[r][c]=level*(-1);
                        queue.add(new int[]{r,c});
                    }
                }
                
            }
            level++;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                matrix[i][j]=Math.abs(matrix[i][j]);
            }
        }
        return matrix;
    }
}