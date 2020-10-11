# Time Complexity : O(m x n) time 
# Space Complexity : O(m x n) space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
    #1) We can level all 0's as level 1 and for each cell (up,down,left,right) to 0th cell, we can add 1 and add the new cell to our queue
    #2) we can maintain a level parameter to increment each time or we can add 1 + matrix[curr[0]][curr[1]] to our matrix[r][c] cell as each cell level wise will increment by one.
class Solution:
    # 1) BFS Approach 
    def updateMatrix(self, matrix):
        if not matrix:
            return matrix 
        m , n = len(matrix) , len(matrix[0])
        q = []
        level = 1
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    q.append([i,j])
                else:
                    matrix[i][j] = -1 
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        while q:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                for dir in dirs:
                    r = dir[0] + curr[0]
                    c = dir[1] + curr[1]
                    if r >= 0 and r < m and c >= 0 and c < n and matrix[r][c] == -1:
                        matrix[r][c] = level 
                        q.append([r,c])
            level += 1 
        return matrix
    
    
if __name__ == "__main__" : 
    s = Solution()
    matrix = [[0,0,0],[0,1,0],[1,1,1]]
    res = s.updateMatrix(matrix)
    for i in range(len(res)):
        print(res[i])