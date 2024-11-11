# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: 01 Matrix

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        q = deque()
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        
        # Initialize distances and queue
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i, j))  # Start BFS from all '0' cells
                else:
                    mat[i][j] = float('inf')  # Set initial distance to infinity for '1' cells

        # BFS to find minimum distances
        while q:
            x, y = q.popleft()
            for dx, dy in dirs:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n:
                    # Update distance if a shorter path is found
                    if mat[nx][ny] > mat[x][y] + 1:
                        mat[nx][ny] = mat[x][y] + 1
                        q.append((nx, ny))

        return mat