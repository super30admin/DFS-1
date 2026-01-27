#---------------Solution 1 : BFS-------------
''' Time Complexity : O(m*n) 
    Space Complexity : O(m*n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

    Approach : Start by adding all 0's to queue,
               Process level wise and increament the distance
'''

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows, cols = len(mat),len(mat[0])
        q = deque()
        dirs = [(-1,0),(1,0),(0,1),(0,-1)]
        
        #adding all 0 in the queue
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] *= -1
        
        dist = 1
        while q:
            size = len(q) 
            for _ in range(size):
                i, j = q.popleft()
                for dir in dirs:
                    r = dir[0] + i
                    c = dir[1] + j
                    if 0<=r<rows and 0<=c<cols and mat[r][c] == -1:
                        q.append((r,c))
                        mat[r][c] = dist
            dist += 1        
        return mat

#---------------Solution 2 : DFS with dp-------------
''' Time Complexity : O(m*n) 
    Space Complexity : O(m*n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''
class Solution:
    def updateMatrix(self, mat):
        self.dirs = [[-1,0],[1,0],[0,1],[0,-1]]
        self.m = len(mat)
        self.n = len(mat[0])
        self.result = [[0]*self.n for _ in range(self.m)]

        for i in range(self.m):
            for j in range(self.n):
                if mat[i][j] == 1:
                    self.result[i][j] = self.dfs(mat, i, j)
        return self.result

    def dfs(self, mat, i, j):
        # base case
        if i > 0 and mat[i-1][j] == 0:
            return 1
        if i < self.m-1 and mat[i+1][j] == 0:
            return 1
        if j > 0 and mat[i][j-1] == 0:
            return 1
        if j < self.n-1 and mat[i][j+1] == 0:
            return 1

        top = 9999
        left = 9999
        bottom = 9999
        right = 9999

        if i > 0 and self.result[i-1][j] != 0:
            top = self.result[i-1][j]

        if j > 0 and self.result[i][j-1] != 0:
            left = self.result[i][j-1]

        if j < self.n-1:
            if self.result[i][j+1] == 0:
                self.result[i][j+1] = self.dfs(mat, i, j+1)
            right = self.result[i][j+1]

        if i < self.m-1:
            if self.result[i+1][j] == 0:
                self.result[i+1][j] = self.dfs(mat, i+1, j)
            bottom = self.result[i+1][j]

        return 1 + min(top, min(left, min(bottom, right)))