# Time Complexity : O(m*n) 
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        q = deque()
        res = [[float("inf")] * n for i in range(m)]
        dirs = [(-1,0),(1,0),(0,-1),(0,1)]
        for i in range(m):
            for j in range(n):
                if(mat[i][j]==0):
                    res[i][j]=0
                    q.append([i,j])
        while(len(q)>0):
            r, c = q.popleft()
            for dir in dirs:
                row = dir[0] + r
                col = dir[1] + c
                if(row>=0 and col>=0 and row<m and col<n and res[row][col]>res[r][c]+1):
                    res[row][col]=res[r][c]+1
                    q.append([row,col])
        return res