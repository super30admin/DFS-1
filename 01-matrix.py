'''
Docstring for 01-matrix
TC: O(m * n)
SC: O(m * n)
'''
class Solution:
    def __init__(self):
        self.dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        

    def updateMatrix(self, mat):
        m = len(mat)
        n = len(mat[0])
        q = []
        for i in range(m):
            for j in range(n):
                # add each 0 to queue
                if mat[i][j] == 0:
                    q.append([i, j])
                # convet to -1 to know if the element data is distance or value
                if mat[i][j] == 1:
                    mat[i][j] = -1
        dis = 0
        while len(q) > 0:
            size = len(q)
            dis += 1
            for i in range(size):
                curr = q.pop(0)
                # check or each direction
                for dir in self.dirs:
                    r = curr[0] + dir[0]
                    c = curr[1] + dir[1]
                    # Out of Bound check
                    if r >= 0 and c >= 0 and r < m and c < n and mat[r][c] == -1:
                        mat[r][c] = dis
                        q.append([r, c])
        
        return mat



mat = [[0,0,0],[0,1,0],[0,0,0]]
s = Solution()
print(s.updateMatrix(mat))

mat = [[0,0,0],[0,1,0],[1,1,1]]
s = Solution()
print(s.updateMatrix(mat))