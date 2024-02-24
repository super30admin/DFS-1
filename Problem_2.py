#
# @lc app=leetcode id=542 lang=python3
#
# [542] 01 Matrix
#

# @lc code=start
'''
Time Complexity - O(mn) for BFS and O(mn) for DP
Space Complexity - O(mn) for BFS(queue) and O(mn) for DP

Both codes work on Leetcode
'''
from collections import deque
class Solution:
    def __init__(self):
        self.dirs = [[-1,0],[1,0],[0,-1],[0,1]]
        #self.result =[]
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q = deque()
        #find the 0 in the matrix
        m, n = len(mat), len(mat[0])
        #self.result = [[0 for j in range(n)] for i in range(m)] #result array for top down DP
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0: 
                    q.append((i,j)) #add 0 to the queue
                else:
                    mat[i][j] = -1 #change 1 to -1 so that we do not affect calculations
        dist = 1 #set initial distance to 1 as any -1 near 0 will be at distance 1 from 0
        while q:
            for i in range(len(q)):
                pos = q.popleft() #process 1st 0 in queue
                r = pos[0]
                c = pos[1] #get its position
                for dir in self.dirs:
                    nr = r + dir[0]
                    nc = c + dir[1] #calculate neighbor position
                    if nr >= 0 and nr < m and nc >=0 and nc < n and mat[nr][nc] == -1: #check if the neighbor is within bounds and is -1
                        mat[nr][nc] = dist #set distance 
                        q.append((nr,nc)) #append to queue to process its neighbors
            dist+=1 #increment the distance to increase every level
        # for i in range(m):
        #     for j in range(n):
        #         if mat[i][j] == -1:
        #             self.result[i][j] = self.dfs(mat, i, j, m, n) #run dfs on every -1 we encounter
        # return self.result
        return mat
        
    def dfs(self, mat, i, j, m, n):
        if i < m-1 and mat[i+1][j] == 0: #return 1 as distance if 0 at bottom
            return 1
        if j < n-1 and mat[i][j+1] == 0: #return 1 as distance if 0 at right
            return 1
        if i > 0 and mat[i-1][j] == 0: #return 1 as distance if 0 on top
            return 1
        if j > 0 and mat[i][j-1] ==0: #return 1 as distance if 0 at bottom
            return 1
        
        top, bottom, left, right = 1e9, 1e9, 1e9, 1e9 #set top, botttom, right , left to infinity
        if i > 0 and self.result[i-1][j] != 0:
            top = self.result[i-1][j] #we are traversing down and right so should know the distance to nearest 0 from left and top
        
        if j > 0 and self.result[i][j-1] != 0:
            left = self.result[i][j-1]
        
        if i < m-1: #getting the distance at bottom
            if self.result[i+1][j] == 0:
                self.result[i+1][j]=self.dfs(mat, i+1,j, m, n)
            bottom = self.result[i+1][j]
        
        if j < n-1: #getting distance on right
            if self.result[i][j+1] == 0:
                self.result[i][j+1]=self.dfs(mat, i, j+1, m, n)
            right = self.result[i][j+1]
        
        return min(top,min(bottom,min(left,right))) + 1 #distance is minimum of all distance + 1

                
        
# @lc code=end

