class Solution:
    def __init__(self):
        self.m = 0
        self.n = 0
        self.color = None
        self.dirs = None
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image or image[sr][sc]==newColor:
            return image  
        self.color = image[sr][sc]
        self.m = len(image)
        self.n = len(image[0])
        stack = list()
        self.dirs = ((0,1),(0,-1),(-1,0),(1,0))
        
        self.dfs(image, sr, sc, newColor)
        return image
    
    def dfs(self, image, sr, sc, newColor):
        #Base
        if sr < 0 or sr == self.m or sc < 0 or sc == self.n or image[sr][sc] != self.color:
            return
        #Logic
        image[sr][sc] = newColor
        for dir in self.dirs:
            r = sr + dir[0]
            c = sc + dir[1]
            self.dfs(image, r, c, newColor)
            
