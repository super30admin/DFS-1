#BFS
""""// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


# TC- O(m*n), SC-0(m*n)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat or len(mat) == 0:
            return mat
        m = len(mat)
        n = len(mat[0])
        d = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        q = deque()

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i, j))
                else:
                    mat[i][j] = -1
        while q:
            curr = q.popleft()
            for k in d:
                nr = curr[0] + k[0]
                nc = curr[1] + k[1]
                if nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1:
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1
                    q.append((nr, nc))
        return mat

# class Solution:
#     def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
#         if not mat or len(mat)==0:
#             return mat
#         m=len(mat)
#         n=len(mat[0])
#         d=[[0,1],[1,0],[0,-1],[-1,0]]
#         q=deque()

#         for i in range(m):
#             for j in range(n):
#                 if mat[i][j]==0:
#                     q.append((i,j))
#                 else:
#                     mat[i][j]=-1

#         distance=1

#         while q:
#             size=len(q)
#             for i in range(size):
#                 curr=q.popleft()
#                 for k in d:
#                     nr=curr[0]+k[0]
#                     nc=curr[1]+k[1]
#                     if nr>=0 and nc>=0 and nr<m and nc<n and mat[nr][nc]==-1:
#                         mat[nr][nc]=distance
#                         q.append((nr,nc))
#             distance+=1
#         return mat




# TC- O(m*n^2), SC-0(m*n)
# class Solution:
#     def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
#         if not mat or len(mat)==0:
#             return mat
#         m=len(mat)
#         n=len(mat[0])
#         d=[[0,1],[1,0],[0,-1],[-1,0]]

#         for i in range(m):
#             for j in range(n):
#                 if mat[i][j]==1:
#                     q=deque()
#                     flag=False
#                     distance=0
#                     q.append((i,j))
#                     while q and not flag:
#                         size=len(q)
#                         for _ in range(size):
#                             curr=q.popleft()
#                             for k in d:
#                                 nr=curr[0]+k[0]
#                                 nc=curr[1]+k[1]
#                                 if nr>=0 and nc>=0 and nr<m and nc<n :
#                                     if mat[nr][nc]==0:
#                                         flag=True
#                                         break
#                                     else:
#                                         q.append((nr,nc))
#                                 if flag:
#                                     break
#                             if flag:
#                                 break
#                         distance+=1
#                     mat[i][j]=distance
#         return mat
