class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        if not mat:
            return None
        
        m = len(mat)
        n = len(mat[0])
        q = list()
        
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1
                          
        if not q:
            return None
        
        dir = ((0,1),(1,0),(0,-1),(-1,0))
        dist = 1
        while q:
            #print(q)
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                for dirs in dir:
                    r = curr[0] + dirs[0]
                    c = curr[1] + dirs[1]
                    if r>=0 and r<m and c>=0 and c<n and mat[r][c]==-1:
                        mat[r][c] = dist
                        q.append((r,c))
            print(mat)
            dist+=1
            
        return mat

#      BFS soln - time complexity is O(n) and space is also the same
                
                
