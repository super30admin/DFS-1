from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = deque()
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 1:
                    mat[i][j] = 10**5
                if mat[i][j] == 0:
                    queue.append((i,j))
                    
        while len(queue) != 0:
            index = queue.popleft()
            x,y = index[0],index[1]
            if x + 1 < len(mat)  and mat[x+1][y] > mat[x][y] + 1:
                mat[x+1][y] = mat[x][y] + 1
                queue.append((x+1,y))
            if y + 1 < len(mat[0])  and mat[x][y+1] > mat[x][y] + 1:
                mat[x][y+1] = mat[x][y] + 1
                queue.append((x,y+1))
            if y - 1 >= 0 and mat[x][y-1] > mat[x][y] + 1:
                mat[x][y-1] = mat[x][y] + 1
                queue.append((x,y-1))
            if x - 1 >= 0 and mat[x-1][y] > mat[x][y] + 1:
                mat[x-1][y] = mat[x][y] + 1
                queue.append((x-1,y))
                
        
        return mat