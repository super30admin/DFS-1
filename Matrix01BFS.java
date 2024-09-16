// Time Complexity: O(n)
// Space Complexity: O(n)
// formulat: row_index * cols + col_index
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		if (matrix[i][j] == 0) {
        			queue.offer(i * cols + j);
        		} else if (matrix[i][j] == 1) {
        			matrix[i][j] = Integer.MAX_VALUE;	
        		}
        	}
        }

        int[] dir = {0, 1, 0, -1, 0};

        while(!queue.isEmpty()) {
        	int top = queue.poll();
        	for (int k = 0; k < dir.length - 1; k++) {
        		int x = top/cols + dir[k];  // new row index
        		int y = top%cols + dir[k + 1]; // new col index
        		if (x >= 0 && x < rows && y >= 0 && y < cols &&
        			matrix[x][y] > 0 &&
        			matrix[x][y] > matrix[top/cols][top%cols] + 1) {
        			matrix[x][y] = matrix[top/cols][top%cols] + 1;
        			queue.offer(x * cols + y);
        		}
        	}
        }

        return matrix;
    }
}