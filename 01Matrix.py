# Time Complexity : O(nxm)
# Space Complexity : O(nxm)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use iterate RDLT (right Down Left Top nodes) and find the nearest 0 by making 1 as -1 initially then update the distance at each level.

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m=len(mat)
        n=len(mat[0])
        q=deque()
        dirs=[[-1,0],[0,1],[1,0],[0,-1]]
        for i in range(0,m):
            for j in range(0,n):
                if(mat[i][j]==0):
                    q.append([i,j])
                else:
                    mat[i][j]=-1
        dist=1
        while(len(q)):
            s=len(q)
            for k in range(s):
                curr=q.popleft()       
                for dir in dirs:
                    nr=curr[0]+dir[0]
                    nc=curr[1]+dir[1]
                    if (nr<m and nc<n and nr>=0 and nc>=0):
                        if(mat[nr][nc]==-1):
                            mat[nr][nc]=dist
                            q.append([nr,nc])
            dist+=1
        return mat