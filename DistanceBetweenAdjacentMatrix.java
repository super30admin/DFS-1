//TimeComplexity-O(n*m)
//Space-O(n*m)
class Solution {
    private int[][] directions={{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0||
          matrix==null)
        {
            return matrix;
        }
        Queue<int[]>queue=new LinkedList();
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    queue.add(new int[]{i,j});
                }
                else{
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        while(!queue.isEmpty())
        {
            int[] front=queue.poll();
            int i=front[0];
            int j=front[1];
            for(int[] dirs:directions)
            {
                int r=i+dirs[0];
                int c=j+dirs[1];
            
            if(r>=0 && r<matrix.length&& c>=0 && c<matrix[0].length &&(matrix[i]            [j]+1<matrix[r][c]))
            {
                matrix[r][c]=matrix[i][j]+1;
                queue.add(new int[]{r,c});
            }
        }
    }
                return matrix;
    }
}