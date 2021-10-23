# // Time Complexity : O(m*n) where m,n are rows and columns of the matrix respectively
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : 
# // Any problem you faced while coding this : 

# // Your code here along with comments explaining your approach 
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        row = len(mat)
        col = len(mat[0])
        queue = deque()
        for i in range(row):
            for j in range(col):
                if mat[i][j] == 0:
                    queue.append([i,j])
                else:
                    mat[i][j] = float('inf')
                    
        directions = [(-1,0),(0,-1),(1,0),(0,1)]
        while queue:
            x,y = queue.popleft()
            for dx,dy in directions:
                r = x+dx
                c = y+dy
                if 0 <= r < row and 0 <= c < col and mat[r][c] > mat[x][y]+1:
                    mat[r][c] = mat[x][y] + 1
                    queue.append([r,c])
        return mat