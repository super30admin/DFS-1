"""
We have to return the distance of the nearest 0 from every node in a matrix
Brute Force :
For every 1 start a fresh BFS, we put all its neighbors inside the queue and check if they are 1. Since we have put immediate neighbors, if they are 0, weupdate the value to distance = 1
We will increase the distance count and keep on adding the next immediate neighbors to the queue.
TC = O(mn)(mn)
SC = O(mn)

Optimization : 
Instead of putting 1s, We can put all the 0s in the queue. Their immediate neighbors which are 1, will be at a distance 1 from the 0s.
As and when we  find more 1s for different levels, we replace the values by distance from initially added 0s in the queue

To distinguish between the "distance" and the "element" we replace all 1 with -1 
TC = O(mn)
SC = O(mn)

"""

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m = len(matrix)
        n = len(matrix[0])
        
        dirs = [(1,0),(0,1),(0,-1),(-1,0)]
        q = deque()

        for i in range(m):
            for j in range(n):
                if matrix[i][j]==0:
                    q.append((i,j))
                else:
                    matrix[i][j]==-1
        dist = 1      
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for d in dirs:
                    nr = curr[0]+d[0]
                    nc = curr[1]+d[1]
                    
                    if nr>=0 and nc>=0 and nr<m and nc<n and matrix[nr][nc]==-1:
                        matrix[nr][nc]=dist
                        q.add((nr, nc))
            dist+=1
        
        return matrix
                        

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        q = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1

        dist = 1
        dirs = [(1,0),(0,1),(0,-1),(-1,0)]
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for d in dirs:
                    nr, nc = curr[0] + d[0], curr[1] + d[1]
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1:
                        mat[nr][nc] = dist 
                        q.append((nr,nc))
            dist += 1
        return mat