# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA
#Initially adding all the 0's in queue and replacing 1's by -1 as distance from 0 can also be 1(to distinguish between 1 element and 1 distance). Then poping 0s from the queue and updating the adjacent -1s to distance from the current 0's index.


from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat:
            return mat
        m=len(mat)
        n=len(mat[0])
        q=deque()
        dist=1
        dirs=[(0,-1),(-1,0),(1,0),(0,1)]
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    q.append((i,j))
                else:
                    #replacing 1s by -1 initially as distance from 0 can also be 1
                    mat[i][j]=-1
        if not q:
            return mat

        while q:
            qlen=len(q)
            for i in range(qlen):
                curr=q.popleft()
                for dir in dirs:
                    nr=curr[0]+dir[0]
                    nc=curr[1]+dir[1]
                    if nr>=0 and nc>=0 and nr<m and nc<n and mat[nr][nc]==-1:
                        mat[nr][nc]=dist
                        q.append((nr,nc))
            dist+=1
        
        return mat





        


