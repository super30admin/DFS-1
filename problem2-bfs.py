from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        count = 1
        q = deque()
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1
        
        dirs = [[1,0], [-1,0], [0,1], [0,-1]]
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for d in dirs:
                    r = d[0] + curr[0]
                    c = d[1] + curr[1]
                    if r >=0 and c >=0 and r < len(mat) and c < len(mat[0]) and mat[r][c] == -1:
                        mat[r][c] = count
                        q.append([r,c])
            count +=1
        return mat   
    
#Time and space compelities are O(m*n)
#Approach used: marked all the 1s as negative and assigned them distance which was incremented after processing nodes at each level 