from collections import deque

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        rows, cols = len(matrix), len(matrix[0])
        distance_matrix = [[-1] * cols for _ in range(rows)]
        queue = deque()
      
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == 0:
                    distance_matrix[i][j] = 0
                    queue.append((i, j))

        directions = ((-1, 0), (0, -1), (1, 0), (0, 1))
      
        while queue:
            i, j = queue.popleft()
            for delta_i, delta_j in directions:
                neighbor_i, neighbor_j = i + delta_i, j + delta_j
                if 0 <= neighbor_i < rows and 0 <= neighbor_j < cols and distance_matrix[neighbor_i][neighbor_j] == -1:
                    distance_matrix[neighbor_i][neighbor_j] = distance_matrix[i][j] + 1
                    queue.append((neighbor_i, neighbor_j))
      
        return distance_matrix
        
