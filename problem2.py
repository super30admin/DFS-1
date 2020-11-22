#Problem: 01 Matrix

class Solution:
                
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        queue = collections.deque()
        dist_matrix = matrix[:]
           
        for idx_i, rows in enumerate(matrix):
            for idx_j, elem in enumerate(rows):
                if elem == 0:
                    queue.append((idx_i, idx_j))
                    dist_matrix[idx_i][idx_j] = 0
                else:
                    dist_matrix[idx_i][idx_j] = -1
        
        while queue:
            cell_i, cell_j = queue.popleft()

            for i,j in [(cell_i+1, cell_j), (cell_i, cell_j+1), (cell_i-1, cell_j), (cell_i, cell_j-1)]:
                if 0 <= i < len(matrix) and 0 <= j < len(matrix[0]):
                    if dist_matrix[i][j] == -1:
                        dist_matrix[i][j] = dist_matrix[cell_i][cell_j] + 1
                        queue.append((i, j))

        return dist_matrix
		
		
# Time Complexity: O(m*n) where m is rows and n is columns in matrix

# Space Complexity: O(m*n)  where m is rows and n is columns in matrix

# Approach: Initialize all 1's in the matrix to -1. 
# 			Push all the O's onto a queue and do a BFS on the matrix.
#			Update the matrix cost whenever we see a -1