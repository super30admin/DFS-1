class Solution {
    int rows;
    int cols;
    int dirs[][] = new int[][] {
        {
            1,
            0
        }, {-1,
            0,
        }, {
            0,
            -1
        }, {
            0,
            1
        }
    };
    


    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return matrix;

        this.rows = matrix.length;
        this.cols = matrix[0].length;

        int output[][] = new int[rows][cols];
        boolean visited[][] = new boolean[rows][cols];


        Queue < int[] > queue;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    queue = new LinkedList < > ();
                    output[i][j] = Integer.MAX_VALUE;
                    
                    boolean flag = false;

                    queue.add(new int[] {
                        i,
                        j
                    });

                    int count = 0;

                    while (!queue.isEmpty() && !flag) 
                    {
                        int size = queue.size();
                        count++;

                        for (int l = 0; l < size; l++) 
                        {
                            int current[] = queue.poll();
                            for (int dir[]: dirs) 
                            {
                                
                                int row = current[0] + dir[0];
                                int col = current[1] + dir[1];

                                if (row < rows && row >= 0 && col < cols && col >= 0 && output[row][col]!=Integer.MAX_VALUE && !visited[i][j]) 
                                {
                                    if (matrix[row][col] == 0) 
                                    {
                                        output[i][j] = Math.min(count, output[i][j]);
                                        visited[i][j] = true;
                                        flag = true;
                                        break;
                                    } 
                                    else
                                        queue.add(new int[] {row,col});
                                }
                            }
                            if(flag) break;
                        }
                        if(flag) break;
                    }
                    
                }

        return output;

    }
}