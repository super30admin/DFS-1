//Time complexity: O(m*n)**2
//Space complexity: O(m*n)
//Executed on leet code.

class Solution {
    int m = -1, n=-1;
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        for(int i=0;i<m;i++)        //Traversing each index and if the value is not equal to 0 replace with distance to nearest 0.
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]!=0)
                {
                    int dis = calDistance(matrix, i, j);
                    matrix[i][j] = dis;
                }
            }
        }
        
        return matrix;
    }
    
    int calDistance(int[][] matrix, int i, int j)
    {
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        int dis = 1;                //Finding distance of nearest 0. Storing the neighbours in a queue at every level and pulls all the indices that added in previous level.
        
        while(!queue.isEmpty())     //returns distance when zero is found.
        {
            int s = queue.size();
            for(int p =0; p<s; p++)
            {
                int[] index = queue.poll();
                for(int[] dir : directions)
                {
                    int x = index[0]+dir[0];
                    int y = index[1]+dir[1];
                    if(x>=0 && x<m && y>=0 && y<n)
                    {
                        if(matrix[x][y]==0)
                            return dis;
                        else
                            queue.add(new int[]{x,y});                       
                    }
                }
            }
            dis++;
        }
        return 0;
    }
}