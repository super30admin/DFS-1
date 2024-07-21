from collections import deque

def updateMatrix(mat):
    rows, cols = len(mat), len(mat[0])
    distance_matrix = [[float('inf')] * cols for _ in range(rows)]
    queue = deque()
    
    # Initialize queue with all 0 cells and set their distance to 0
    for r in range(rows):
        for c in range(cols):
            if mat[r][c] == 0:
                queue.append((r, c))
                distance_matrix[r][c] = 0
    
    # Directions for moving up, down, left, right
    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    
    # BFS
    while queue:
        r, c = queue.popleft()
        
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            
            if 0 <= nr < rows and 0 <= nc < cols:
                if distance_matrix[nr][nc] > distance_matrix[r][c] + 1:
                    distance_matrix[nr][nc] = distance_matrix[r][c] + 1
                    queue.append((nr, nc))
    
    return distance_matrix

# Example usage
matrix = [
    [0, 0, 0],
    [0, 1, 0],
    [1, 1, 1]
]
output = updateMatrix(matrix)
for row in output:
    print(row)


#time = O(N×M)
#space = O(N×M)