# problem 1 : 733. Flood Fill : https://leetcode.com/problems/flood-fill/
# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        ## DFS
#         self.row, self.col = len(image), len(image[0])
        # if image[sr][sc] == newColor:
        #     return image
        # self.color = image[sr][sc]
#         self.dfs(image, sr, sc, newColor)
#         return image
    
#     def dfs(self, image, sr,sc, newColor):
#         #base case
        
#         #logic
#         directions = [(1,0),(-1,0),(0,1),(0,-1)]
#         image[sr][sc] = newColor
        # for dir in directions:
        #     r, c = sr + dir[0], sc + dir[1]
            # if 0 <= r < self.row and 0 <= c < self.col and image[r][c] ==self.color:
#                 self.dfs(image, r, c, newColor)

        ## BFS
        row, col = len(image), len(image[0])
        if image[sr][sc] == newColor:
            return image
        color = image[sr][sc]
        image[sr][sc] = newColor
        de = collections.deque([(sr,sc)])
        directions = [(1,0),(-1,0),(0,1),(0,-1)]
        while de:
            sr , sc = de.popleft()
            for dir in directions:
                r, c = sr + dir[0], sc + dir[1]
                if 0 <= r < row and 0 <= c < col and image[r][c] ==color:
                    image[r][c] = newColor
                    de.append((r,c))
        return image
            


# problem 2 : 542. 01 Matrix : https://leetcode.com/problems/01-matrix/
# Time Complexity : O(n*m) 
# Space Complexity : O(n*m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        de = collections.deque()
        rows, cols = len(matrix), len(matrix[0])
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == 0:
                    de.append((i,j))
                else:
                    matrix[i][j] = -1
        
        directions = [(0,1), (0,-1), (1,0), (-1,0)]
        level = 1
        while de:
            for i in range(len(de)):
                row, col = de.popleft()
                for di in directions:
                    r, c = row+di[0], col + di[1]
                    if 0<= r < rows and 0 <= c < cols and matrix[r][c] == -1:
                        matrix[r][c] = level
                        de.append((r,c))
            level += 1
        return matrix

