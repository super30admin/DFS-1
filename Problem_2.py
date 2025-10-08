# // Time Complexity : O(m*n)
# // Space Complexity : O(m*n)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        n = len(mat)
        m = len(mat[0])
        visited = [[False] * m for _ in range(n)]
        queue = deque()
        
       
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0:
                    queue.append((i, j))
                    visited[i][j] = True
        
  
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        
        while queue:
            x, y = queue.popleft()
            
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                
                if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
                    visited[nx][ny] = True
                    mat[nx][ny] = mat[x][y] + 1
                    queue.append((nx, ny))
        
        return mat