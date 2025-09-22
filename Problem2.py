"""
TC: O(N*M) {each cell is visited and processed at most once}
SC: O(N*M) {in the worst-case scenario, the queue could hold all cells in the grid}

Approach:

This problem is solved using a multi-source Breadth-First Search (BFS) to find the shortest distance from every cell to the nearest `0`. 

We begin by initializing the grid for the search. All cells containing a `0` are our **source points** and are added to a queue. 

Cells with a `1` are marked as unvisited by changing their value to `-1`.

The core of the solution is a multi-source BFS that propagates distances outward from all `0`s simultaneously. 

We process cells from the queue one by one, checking their four neighbors. If a neighbor is within the grid boundaries and is unvisited (i.e., its value is `-1`),
we update its distance to be one greater than the current cell's distance and add it to the queue. 

This process continues until all reachable cells have been updated with their shortest distance to a `0`. The function then returns the modified `mat` grid.

The problem ran successfully on LeetCode.
"""

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        def inBounds(x,y):
            return 0<=x<n and 0<=y<m

        n,m = len(mat), len(mat[0])

        q = deque()
        nei = [[0,1], [1,0], [-1, 0], [0, -1]]
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1

        # dist = 0
        while q:

            # for _ in range(len(q)):
            r, c = q.popleft()
            for dr, dc in nei:
                nr, nc = r + dr, c + dc
                if inBounds(nr, nc) and mat[nr][nc] == -1:
                    q.append((nr, nc))
                    mat[nr][nc] = mat[r][c] + 1
            # dist += 1
        
        return mat