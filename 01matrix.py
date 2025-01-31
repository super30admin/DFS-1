#Using size for loop
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q = deque()
        if not mat:
            return mat
        for i in range(len(mat)):
            for j in range(len(mat[i])):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1
        dir = [[0,-1],[0,1],[-1,0],[1,0]]
        lvl=0
        while q:
            size = len(q)
            for i in range(size):
                r,c = q.popleft()
                for j,k in dir:
                    row = r+j
                    col = c+k
                    if row in range(len(mat)) and col in range(len(mat[0])) and mat[row][col] == -1:
                        q.append((row,col))
                        mat[row][col] = lvl+1
            lvl+=1
        return mat

# Not using size for loop
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q = deque()
        if not mat:
            return mat
        for i in range(len(mat)):
            for j in range(len(mat[i])):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1
        dir = [[0,-1],[0,1],[-1,0],[1,0]]
        while q:
            r,c = q.popleft()
            for j,k in dir:
                row = r+j
                col = c+k
                if row in range(len(mat)) and col in range(len(mat[0])) and mat[row][col] == -1:
                    q.append((row,col))
                    mat[row][col] = mat[r][c]+1
        return mat
