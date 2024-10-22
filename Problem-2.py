# T.C = O((m * n)^2) S.C = O(m * n)
class Solution(object):
    #dirs = [(0, -1), (0, 1), (-1, 0), (1, 0)]
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        self.m = len(mat)
        self.n = len(mat[0])
        self.result = [[0] * self.n for _ in range(self.m)]

        for i in range(self.m):
            for j in range(self.n):
                if(mat[i][j] == 1):
                    self.result[i][j] = self.dfs(mat,i,j)
                
        return self.result

    def dfs(self,mat,i,j):
        if(i>0 and mat[i-1][j] == 0): # top
            return 1
        if(i<self.m-1 and mat[i+1][j] == 0): # down
            return 1
        if(j>0 and mat[i][j-1] == 0): # left
            return 1    
        if(j<self.n-1 and mat[i][j+1] == 0): # right
            return 1  

        top = 9999
        left = 9999
        down = 9999
        right = 9999

        if(i>0 and self.result[i-1][j]!=0):
            top = self.result[i-1][j]

        if(j>0 and self.result[i][j-1]!=0):
            left = self.result[i][j-1]

        if(i<self.m-1):
            if(self.result[i+1][j]==0):
                self.result[i+1][j] = self.dfs(mat,i+1,j)  
            down = self.result[i+1][j]

        if(j<self.n-1):
            if(self.result[i][j+1]==0):
                self.result[i][j+1] = self.dfs(mat,i,j+1)  
            right = self.result[i][j+1] 

        self.result[i][j] = 1 + min(top, down, left, right)     
        return self.result[i][j]  

        