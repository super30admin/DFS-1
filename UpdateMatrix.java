// Time Complexity : The time complexity is O(m*n) where m is the number of rows and n is the number of columns
// Space Complexity : The space complexity is O(m*n) where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] matrix) {

        if(matrix == null || matrix[0] == null){
            return matrix;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] output = new int[rows][columns];

        for(int i=0;i<rows;i++){
            Arrays.fill(output[i],Integer.MAX_VALUE);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<rows;i++){

            for(int j=0;j<columns;j++){

                if(matrix[i][j] == 0){
                    q.offer(i);
                    q.offer(j);
                    output[i][j]=0;
                }
            }
        }

        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){

            int row = q.poll();
            int column = q.poll();

            for(int i=0;i<dir.length;i++){

                int newRow = row + dir[i][0];
                int newColumn = column + dir[i][1];

                // bfs
                if(newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] != 0){
                    if(output[newRow][newColumn] > output[row][column] + 1){
                        q.offer(newRow);
                        q.offer(newColumn);
                        output[newRow][newColumn] = output[row][column] + 1;
                    }
                }
            }
        }

        return output;

    }
}