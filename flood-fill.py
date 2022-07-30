"""
Runtime Complexity:
O(m*n)- because the image is a 2D grid of m rows and n columns.
Space Complexity;
O(m*n) - in the worst case the recursove stack may end up with m*n elements if all the elements in the grid are same.
Yes, the code worked on leetcode.
"""



class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        rows, cols = len(image), len(image[0])
        oldColor = image[sr][sc]
        def dfs(r, c):
            if r<0 or c<0 or r>=rows or c>=cols or image[r][c] != oldColor:
                return
            if image[r][c] != color:
                image[r][c] = color
                dfs(r+1, c)
                dfs(r-1, c)
                dfs(r, c+1)
                dfs(r, c-1)
                
            else:
                return 
        
                
        dfs(sr, sc)
        return image


#Another approach
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image or len(image)==0 or image[sr][sc]==color:
            return image
        self.m = len(image)
        self.n = len(image[0])
        self.dirs = [[-1,0],[1,0],[0,-1],[0,1]]
        self.oldColor = image[sr][sc]
        self.dfs(image,sr,sc,self.oldColor,color)
        return image
    def dfs(self,image,row,col,oldColor, color):
        if (row < 0 or row == self.m or col<0 or col == self.n or image[row][col]!=self.oldColor):
                return
        image[row][col] = color
        for dir_ in self.dirs:
            nr = row + dir_[0]
            nc = col + dir_[1]
            self.dfs(image,nr,nc,oldColor, color)