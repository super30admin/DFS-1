"""
TC: O(n*m) iterate through all cells
SP: O(1) matrix is manipulated for seen cells

"""

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q = deque()
        seen = set()
        rows, cols = len(mat), len(mat[0])
        directions = [(-1,0), (1,0), (0, -1), (0,1)]
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1
        level = 0
        while q:
            for i in range(len(q)):
                r,c = q.popleft()
                for dr, dc in directions:
                    nr, nc = dr+r, dc+c
                    if 0<=nr<rows and 0<=nc<cols and mat[nr][nc]==-1:
                        mat[nr][nc]=level+1
                        q.append((nr,nc))
            level+=1
        return mat