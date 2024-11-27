"Time Complexity is O(M*N)"
"Space Complexity is O(M*N)"

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        queue = deque()
        direction_array = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append((i,j))
                else:
                    mat[i][j] = -1
        
        while(queue):
            r, c = queue.popleft()
            for dx, dy in direction_array:
                nr = r + dx
                nc = c + dy

                if (nr>=0 and nc>=0 and nr<m and nc<n and mat[nr][nc] == -1):
                    mat[nr][nc] = mat[r][c] + 1
                    queue.append((nr,nc))
        return mat


        