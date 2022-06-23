#Time complexity : O(M*N)
#Space complexity : O(M*N)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        #Take all the zeros inside a queue, each time pop the front element from q and check if it's neighbours has 1.
        q = deque()
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if(not mat[i][j]):
                    q.append((i,j))
                else:
                    mat[i][j] = -1*mat[i][j]
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        
        while(len(q)):
            currRow , currCol = q.popleft()
            for direction in dirs:
                row = currRow + direction[0]
                col = currCol + direction[1]
                if(row >= 0 and col >= 0 and row < len(mat) and col < len(mat[0]) and mat[row][col] == -1):
                    if(mat[row][col] == -1):
                        mat[row][col] = mat[currRow][currCol] + 1
                    else:
                        mat[row][col] = min(mat[row][col], mat[currCol][currRow]+1)
                    q.append((row,col))
        return mat
            
