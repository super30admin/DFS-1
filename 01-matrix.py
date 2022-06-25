# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# BFS
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        from collections import deque
        q=deque()
        m=len(mat)
        n=len(mat[0])
        directions=[[0,1],[0,-1],[1,0],[-1,0]]
        count_1=0
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    q.append((i,j))
                else:
                    mat[i][j]=-1
        di=0
        # print(q)
        while len(q)!=0:
            for i in range(len(q)):
                cur=q.popleft()
                for d in directions:
                    r=cur[0]+d[0]
                    c=cur[1]+d[1]
                    if r<m and c<n and r>=0 and c>=0 and mat[r][c]==-1:
                        q.append((r,c))
                        mat[r][c]=di+1
            di+=1
        return mat
    # BFS with 1's in queue
    # Time Complexity: O((m*n)**2)
    # Space Complexity: O(m*n)
    # def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
    #     from collections import deque
    #     # q=deque()
    #     m=len(mat)
    #     n=len(mat[0])
    #     directions=[[0,1],[0,-1],[1,0],[-1,0]]
    #     for i in range(m):
    #         for j in range(n):
    #             if mat[i][j]==1:
    #                 flag=False
    #                 q=deque()
    #                 q.append((i,j))
    #                 di=0
    #                 while len(q)!=0:
    #                     for k in range(len(q)):
    #                         curr=q.popleft()
    #                         for d in directions:
    #                             r=curr[0]+d[0]
    #                             c=curr[1]+d[1]
    #                             if r>=0 and c>=0 and r<m and c<n:
    #                                 if mat[r][c]==0:
    #                                     flag=True
    #                                     break
    #                                 else: q.append((r,c))
    #                         if flag==True: break       
    #                     di+=1
    #                     if flag==True: break
    #                 mat[i][j]=di
    #     return mat
            
            
        