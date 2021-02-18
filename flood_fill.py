# O(N*M) TIME AND O(N*M) SPACE WHERE N,M ARE ROWS,COLS OF IMAGE
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        visited = [[False for j in range(len(image[0]))] for i in range(len(image))]
        self.dfs(sr,sc,image,image[sr][sc],newColor,visited)
        return image
    
    def dfs(self,i,j,image,color,newColor,visited):
        if visited[i][j] or image[i][j] == newColor:
            return
        visited[i][j] = True
        image[i][j] = newColor
        for direction in [[1,0],[0,1],[-1,0],[0,-1]]:
            row = i + direction[0]
            col = j + direction[1]
            if row >= 0 and row < len(image) and col >= 0 and col < len(image[0]) and image[row][col] == color :
                self.dfs(row,col,image,color,newColor,visited)
    
        