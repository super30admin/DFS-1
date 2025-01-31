class Solution:
    # DFS 
    # TC : O(m*n)
    # SC : O(m*n)
    def dfs(self,image,sr,sc,color,oldcolor):
        # base
        if sr < 0 or sr == self.m or sc < 0 or sc == self.n or image[sr][sc] != oldcolor:
            return
        # logic
        image[sr][sc] = color
        for i,j in self.directions:
            x,y = sr+i,sc+j
            self.dfs(image,x,y,color,oldcolor) 

    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        if image is None or len(image) == 0 or image[sr][sc] == color:
            return image
        self.m,self.n = len(image),len(image[0])
        self.directions = [(0,1),(0,-1),(1,0),(-1,0)]
        self.dfs(image,sr,sc,color,image[sr][sc])
        return image

