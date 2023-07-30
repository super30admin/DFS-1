// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution:
    dirs = [[0,1],[0,-1],[1,0],[-1,0]]
    n = 0
    m = 0
    def numIslands(self, grid: List[List[str]]) -> int:
        self.m = len(grid)
        self.n = len(grid[0])
        count = 0 
        #count no of islands
        for i in range(self.m):
            for j in range(self.n):
                if(grid[i][j]=='1'):
                    count+=1
                    self.dfs(grid,i,j)
        return count
    def dfs(self, grid: List[List[str]], i: int, j: int):
        #base
        if(i<0 or j<0 or i==self.m or j==self.n or grid[i][j]=='0'): 
            return

        #logic
        grid[i][j] = '0'
        for dir in self.dirs:
            nr = i + dir[0]
            nc = j + dir[1]
            self.dfs(grid,nr,nc)


// Time Complexity : O(K*l) K = multiplication of digits and l is avg length of string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

  class Solution:
    i = 0
    def decodeString(self, s: str) -> str:
        currNum = 0
        currStr = ""
        while(self.i<len(s)):
            c = s[self.i]
            if(c.isdigit()):
                currNum = currNum*10 + int(c)
                self.i+=1
            elif(c=="["):  
                self.i+=1
                baby = self.decodeString(s)
                for i in range(currNum):
                    currStr+=(baby)
                currNum = 0
            elif(c=="]"):
                self.i+=1
                return currStr
            else:
                currStr+=c
                self.i+=1
        return currStr
