from collections import deque
class Solution:
    """Optimized BFS Implementation
    Time complexity-O(m*n)
    Space complexity-O(m*n)"""
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q=deque()
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j]==0:
                    q.append([i,j])
                else:
                    mat[i][j]=-1
        dirs=[[1,0],[0,1],[-1,0],[0,-1]]
        while q:
            size=len(q)
            for k in range(size):
                r,c=q.popleft()
                for dir in dirs:
                    nr=r+dir[0]
                    nc=c+dir[1]
                    if nr>=0 and nr<len(mat) and nc>=0 and nc<len(mat[0]) and mat[nr][nc]==-1:
                        mat[nr][nc]=mat[r][c]+1
                        q.append([nr, nc])
        return mat
    
    
    """Normal BFS Implementation
    Time complexity-O((m*n)^2) as we are seeing where the one is and performing bfs on that particular node. So for each node, it would be m*n
    Space Complexity-O((m*n)^2) as we are taking a queue for each node and each queue would take m*n space"""
    # def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
    #     dirs=[[1,0],[0,1],[-1,0],[0,-1]]
    #     for i in range(len(mat)):
    #         for j in range(len(mat[0])):
    #             q=deque()
    #             setval=False
    #             if mat[i][j]==1:
    #                 dist=1
    #                 q.append([i,j])
    #                 while q:
    #                     size=len(q)
    #                     for k in range(size):
    #                         r,c=q.popleft()
    #                         for dir in dirs: 
    #                             nr=r+dir[0]
    #                             nc=dir[1]+c
    #                             if nr>=0 and nr<len(mat) and nc>=0 and nc<len(mat[0]) and mat[nr][nc]==0:
    #                                 mat[i][j]=dist
    #                                 setval=True
    #                                 break
    #                             elif nr>=0 and nr<len(mat) and nc>=0 and nc<len(mat[0]):
    #                                 q.append([nr, nc])
    #                         if setval==True:
    #                             break
    #                     if setval==True:
    #                         break     
    #                     dist+=1
    #     return mat 