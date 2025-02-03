# TC - O(m*n)
# SC - O(m*n)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat == None or mat[0] == None:
            return []

        queue = deque()
        m = len(mat)
        n = len(mat[0])
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append((i,j))
                else:
                    mat[i][j] = -1    
        level = 0
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        while len(queue)!=0:
            size = len(queue)
            for i in range(size):
                r,c = queue.popleft()
                for rr,cc in dirs:
                    newr = rr+r
                    newc =cc+c
                    if newr>=0 and newr<m and newc>=0 and newc<n and mat[newr][newc] == -1:
                        mat[newr][newc] = level+1
                        queue.append((newr,newc))
            level+=1
        return mat                

        
        
