"""
Add all positions of 0s to queue and initialize distances
Apply BFS, update neighbors if a shorter distance is found
Return the distance matrix
"""
"""
Time Complexity: O(m × n) — All cells visited once
Space Complexity: O(m × n) — For visited, dist, and queue
"""

from typing import List
from collections import deque

class oneMatrix:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows, cols = len(mat), len(mat[0])
        queue = deque()
        dist = [[float('inf')] * cols for _ in range(rows)]

        for r in range(rows):
            for c in range(cols):
                if mat[r][c] == 0:
                    dist[r][c] = 0
                    queue.append((r, c))

        directions = [(-1,0), (1,0), (0,-1), (0,1)]

        while queue:
            r, c = queue.popleft()
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols:
                    if dist[nr][nc] > dist[r][c] + 1:
                        dist[nr][nc] = dist[r][c] + 1
                        queue.append((nr, nc))

        return dist

if __name__ == "__main__":
    obj = oneMatrix()
    mat = [[0,0,0],[0,1,0],[0,0,0]]
    result = obj.updateMatrix(mat)
    for row in result:
        print(row)

