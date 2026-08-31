"""
APPROACH:
1. Initialize a queue with the position of every 0 in the matrix, since those are already at distance 0.
2. Mark all 0 cells as visited so they are not processed again.
3. Run multi-source BFS outward from all 0 cells simultaneously, tracking distance as we spread.
4. For each cell visited, record its distance in the result matrix.
5. Continue spreading to unvisited neighbors, increasing distance by 1 each step, until all cells are covered.

PATTERN:
Multi-Source Grid BFS

TIME COMPLEXITY:
O(m x n) - every cell is visited and processed at most once

SPACE COMPLEXITY:
O(m x n) - queue, visited grid, and result grid all scale with matrix size

EXAMPLE:
Input:
mat = [
  [0,0,0],
  [0,1,0],
  [1,1,1]
]

Output:
[
  [0,0,0],
  [0,1,0],
  [1,2,1]
]
Why: each cell's value is its distance to the nearest 0, spreading outward from all zeros at once
"""

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows = len(mat)  # number of rows
        cols = len(mat[0])  # number of columns
        q = collections.deque()  # queue used for BFS

        # build a visited grid, all False initially
        visited = []
        for r in range(rows):
            row = []
            for c in range(cols):
                row.append(False)
            visited.append(row)
        
        # find all 0 cells, they are the BFS starting points at distance 0
        for r in range(rows):
            for c in range(cols):
                if mat[r][c] == 0:
                    q.append([r, c, 0])
                    visited[r][c] = True
        
        directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]  # up, down, left, right

        # build result grid to store final distances, all 0 initially
        result = []
        for r in range(rows):
            row = []
            for c in range(cols):
                row.append(0)
            result.append(row)

        # multi-source BFS spreads outward from all zeros at once
        while q:
            r, c, dist = q.popleft()  # process next cell
            result[r][c] = dist  # record distance to nearest 0

            # check all 4 neighbors of current cell
            for direction in directions:
                new_r = r + direction[0]
                new_c = c + direction[1]

                # check neighbor is inside bounds
                if new_r >= 0 and new_r < rows and new_c >= 0 and new_c < cols:
                    if not visited[new_r][new_c]:
                        visited[new_r][new_c] = True  # mark visited before adding
                        q.append([new_r, new_c, dist + 1])  # one step farther

        return result  # matrix of distances to nearest 0