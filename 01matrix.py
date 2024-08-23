# Time complexity: O(m*n)
# Space Complexity : O(1)
# using BFS
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = deque()
        m = len(mat)
        n = len(mat[0])

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append((i,j,0))
                else:
                    mat[i][j] = -1

        
        pos = [[1,0], [0,1], [-1,0], [0,-1]]
        level = 0
        while queue:
            x,y, level = queue.popleft()
            for i,j in pos:
                r, c = x + i, y + j
                if 0 <= r < m and  0 <= c < n  and mat[r][c] == -1:
                    mat[r][c] = level + 1
                    queue.append((r,c,level+1))
        return mat
            
