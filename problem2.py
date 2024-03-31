# Time and space complexity is O(MN)
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        
       if not mat:
            return mat
        
        r = len(mat)
        c = len(mat[0])
        
        dist = [[ float('inf') for i in range(c)] for j in range(r)]
        
        q = collections.deque()
        
        for i in range(r):
            for j in range(c):
                if mat[i][j]==0:
                    dist[i][j] = 0
                    q.append((i, j))
                    
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        
        while q:
            x, y = q.popleft()
            
            for dx, dy in directions:
                nx = x+dx
                ny = y+dy
                
                if 0<=nx<r and 0<=ny<c:
                    if dist[nx][ny] > dist[x][y]+1:
                        dist[nx][ny] = dist[x][y]+1
                        q.append((nx, ny))
                        
        return dist
                        
        
                        
                