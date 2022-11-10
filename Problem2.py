#Time Complexity - O(m*n)
#Space Complexity - O(m*n)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        dist = [[1,0],[-1,0],[0,1],[0,-1]]
        q = deque([])
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1

        while len(q) != 0:
            r, c = q.popleft()
            for x in dist:
                row = r + x[0]
                col = c + x[1]
                if row >= 0 and row < len(mat) and col >= 0 and col < len(mat[0]) and mat[row][col] < 0:
                    mat[row][col] = mat[r][c] + 1
                    q.append((row,col))

        return mat                