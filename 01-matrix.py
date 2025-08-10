'''
Time Complexity: O(m * n)
Space Complexity: O(m * n) 

Approach: BFS 
1. Initialize a queue and a distance matrix.
2. Enqueue all cells with 0s and set their distance to 0.
3. For each cell, explore its neighbors.
4. If a neighbor is unvisited, update its distance and enqueue it.
5. Continue until all cells are processed.
This ensures that each cell is processed in the shortest path order from the nearest 0. 

'''

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        ROWS, COLS = len(mat), len(mat[0])
        queue = deque()
        distance = [[float("inf") for _ in range(COLS)] for _ in range(ROWS)]
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        visited = set()

        for r in range(ROWS):
            for c in range(COLS):
                if mat[r][c] == 0: 
                    visited.add((r,c))
                    distance[r][c] = 0 
                    queue.append((r, c, 0))

        while queue:
            cr, cc, dist = queue.popleft()

            if mat[cr][cc] == 1:
                distance[cr][cc] = min(dist, distance[cr][cc])

            for dr, dc in directions:
                r = cr + dr
                c = cc + dc

                if r < 0 or r >= ROWS or c < 0 or c >= COLS:
                    continue
                else:
                    if (r, c) not in visited:
                        visited.add((r, c))
                        queue.append((r, c, dist + 1))
        return distance
