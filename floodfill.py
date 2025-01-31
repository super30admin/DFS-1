class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image[sr][sc]==color:
            return image
        m = len(image)
        n = len(image[0])
        dirs=[[-1,0],[0,-1],[1,0],[0,1]]
        oldColor = image[sr][sc]
        def dfs(i,j):
            print(i,j)
            if i<0 or i>m-1 or j<0 or j>n-1 or image[i][j]!=oldColor:
                return 
            image[i][j]=color
            for r,c in dirs:
                row = i+r
                col = j+c
                dfs(row,col)            
    
        dfs(sr,sc)
        return image
        