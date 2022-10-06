"""
FAANMG Problem #66 {Medium}

542. 01 Matrix

Time Complexity : O(N*M)


Space Complexity : O(N*M)


Did this code successfully run on Leetcode : Yes

BFS Solution

@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        # if matrix is null or len of matrix is 0, then return matrix
        if(len(mat) == 0):
            return
        
        
        directions =[[0,1] , [1,0] , [0,-1] , [-1,0]]
        
        rows = len(mat)
        cols =len(mat[0])
        
        q = deque()
        
        # we add the index of 0 to queue and covert 1 to -1
        for i in range (rows):
            for j in range(cols):
                
                if(mat[i][j] ==1):
                    mat[i][j] = -1
                    
                if mat[i][j]==0:
                    q.append([i,j])
                    
        if len(q) == rows*cols or len(q)==0:
            return mat
        
        # declare the distance as 0, since we start from level 0
        distance = 0
        while q:
            
             # maintain the size of the list to differentiate the level of the graph
            size = len(q)
            
            for i in range(size):
                
                r,c=q.popleft()
                
                for dr,dc in directions:
                    nr = dr + r
                    nc = dc + c
                    
                     # do the boundary check condition and we only increase the distance if the element is -1
                    if ( 0 <= nr < rows and 0<= nc< cols and mat[nr][nc] ==-1):
                        q.append([nr,nc])
                        mat[nr][nc] = mat[r][c] + 1
            # increase the distance after each level            
            # distance +=1
            
        return mat
            
 """
FAANMG Problem #66 {Medium}

542. 01 Matrix

Time Complexity : O(N*M)


Space Complexity : O(N*M)


Did this code successfully run on Leetcode : Yes

BFS Solution

@name: Rahul Govindkumar_RN27JUL2022
"""           
            
        
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        # if matrix is null or len of matrix is 0, then return matrix
        if(len(mat) == 0):
            return
        
        
        directions =[[0,1] , [1,0] , [0,-1] , [-1,0]]
        
        rows = len(mat)
        cols =len(mat[0])
        
        q = deque()
        
        # we add the index of 0 to queue and covert 1 to -1
        for i in range (rows):
            for j in range(cols):
                
                if(mat[i][j] ==1):
                    mat[i][j] = -1
                    
                if mat[i][j]==0:
                    q.append([i,j])
                    
        if len(q) == rows*cols or len(q)==0:
            return mat
        
        # declare the distance as 0, since we start from level 0
        distance = 0
        while q:
            
         
                
            r,c=q.popleft()

            for dr,dc in directions:
                nr = dr + r
                nc = dc + c

                 # do the boundary check condition and we only increase the distance if the element is -1
                if ( 0 <= nr < rows and 0<= nc< cols and mat[nr][nc] ==-1):
                    q.append([nr,nc])
                    mat[nr][nc] = mat[r][c] + 1
            # increase the distance after each level            
            # distance +=1
            
        return mat
            
            
"""
FAANMG Problem #66 {Medium}

542. 01 Matrix

Time Complexity : O(N*M)


Space Complexity : O(N*M)


Did this code successfully run on Leetcode : Yes

BFS Solution

@name: Rahul Govindkumar_RN27JUL2022
"""            
        
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        # check for null or an empty matrix
        if not mat or len(mat) == 0:
            return mat

        # calculate rows and columns of the matrix, then assign a dp matrix to store the values of the min distance
        self.rows = len(mat)
        self.cols = len(mat[0])

        dp = [[0 for _ in range(self.cols)] for _ in range(self.rows)]

        # for each element in the matrix we call the dfs to fetch the min distance of 0
        for i in range(self.rows):
            for j in range(self.cols):
                dp[i][j] = self.dfs(mat, dp, i, j)

        return dp

    def dfs(self, mat, dp, row, col):
        # if out of bounds, then return some higher value than our data range
        if row < 0 or row >= self.rows or col < 0 or col >= self.cols:
            return 9999
        # if we encounter a value 0, then we simply return 0
        if mat[row][col] == 0:
            return 0

        # whenever we find a neighbor as 0, we simply return value 1 as that is the distance, in each direction
        if row > 0 and mat[row-1][col] == 0:
            return 1
        if row < self.rows - 1 and mat[row+1][col] == 0:
            return 1
        if col > 0 and mat[row][col-1] == 0:
            return 1
        if col < self.cols - 1 and mat[row][col+1] == 0:
            return 1

        # when we come across a neighbor which is 1 in this problem, we check for all the values in 4-directions and get the min out of all
        # to put the value here. Now, since we were calculating the dp matrix from top and left, so for each index, we'll have to call dfs 
        # for right and bottom value, so that we can get the correct value and not change it every time the neighbors are updated
        top = bottom = left = right = float('inf')
        # check for top element
        if row > 0 and dp[row-1][col] != 0:
            top = dp[row-1][col]
        # check for left element
        if col > 0 and dp[row][col-1] != 0:
            left = dp[row][col-1]
        # check for bottom value
        if row < self.rows-1:
            if dp[row+1][col] == 0:
                dp[row+1][col] = self.dfs(mat, dp, row+1, col)
            bottom = dp[row+1][col]
        # check for right value
        if col < self.cols-1:
            if dp[row][col+1] == 0:
                dp[row][col+1] = self.dfs(mat, dp, row, col+1)
            right = dp[row][col+1]
         # findally returning the min out of all 4-values
        return min(min(left,right),min(top,bottom))+1        
        
                
        
        
        
        