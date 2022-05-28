
#Approach:
#BFS without using visited set and just changing state
#Time Complexity O(MN) M= rows, N=columns of mat
#Space Complexity O(MN)
#It successfully runs on leetcode
from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat: return 0
        q=deque()
        r = len(mat)
        c= len(mat[0])
        onefound= False
        direction = {(0,1),(0,-1),(1,0),(-1,0)}
        for i in range(r):
            for j in range(c):
                if mat[i][j]==0:
                    q.append((i,j))
                else:
                    mat[i][j]=-1
                    onefound = True
        if not onefound: return mat
        while q:
            x,y = q.popleft()
            for i,j in direction:
                nr,nc= x+i,y+j
                if nr >= 0 and nr < r and nc >= 0 and nc < c and mat[nr][nc]==-1:
                    q.append((nr,nc))
                    mat[nr][nc] = mat[x][y] + 1 
            return mat



#using visited set
from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat: return 0
        q=deque()
        r = len(mat)
        c= len(mat[0])
        s= set()
        onefound= False
        direction = {(0,1),(0,-1),(1,0),(-1,0)}
        for i in range(r):
            for j in range(c):
                if mat[i][j]==0:
                    q.append((i,j))
                else:
                    onefound= True
        if not onefound: return mat
 
        while q:
            x,y = q.popleft()
            for i,j in direction:
                nr,nc= x+i,y+j
                if nr >= 0 and nr < r and nc >= 0 and nc < c:
                    if mat[nr][nc]==1 and (nr,nc) not in s:
                        mat[nr][nc] = mat[x][y] + 1 
                        if (nr,nc) not in s: q.append((nr,nc))
                        s.add((nr,nc))
        return mat
                      