 ############# BFS Solution Time: O(m*n) Space: O(m*n) ################
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat:
            return
        m = len(mat)
        n = len(mat[0])
        
        dist = mat
        
        q = collections.deque()
        
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.appendleft((i,j))
                else:
                    dist[i][j] = -1
        dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        level = 0
        while q:
            size = len(q)
            level += 1
            for i in range(size):
                curr = q.pop()
                
                for d in dirs:
                    r = curr[0]+d[0]
                    c = curr[1]+d[1]
                    
                    if r >= 0 and r < m and c >= 0 and c<n:
                        if dist[r][c] == -1:
                            dist[r][c] = level
                            q.appendleft((r,c))
            
                
        return dist