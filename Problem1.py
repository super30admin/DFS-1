#Time Complexity :- O(mxn)
#Space Complexity :- O(mxn)
class Solution:
    m, n = 0, 0
    dirs = []
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image == None or len(image) ==0 or image[sr][sc]==color:
            return image
        oldColor = image[sr][sc]
        self.m = len(image)
        self.n = len(image[0])
        self.dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        self.dfs(image, sr, sc, color, oldColor)
        return image

    def dfs(self, image, row, column, color, oldColor):
        print(self.m,self.n)
        # base
        if row < 0 or column < 0 or row ==self.m or column == self.n or image[row][column]!=oldColor:
            return 
        # logic
        image[row][column] = color
        for dir in self.dirs:
            nr = row + dir[0]
            nc = column + dir[1]
            self.dfs(image,nr, nc, color, oldColor)