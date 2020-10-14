# O(n) time and O(n) space where n is no.of elements of input matrix

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        visited = [[False for j in range(len(image[i]))] for i in range(len(image))]
        initial_color = image[sr][sc]
        self.dfs(sr,sc,initial_color,newColor,image,visited)
        return image
    
    
    def dfs(self,i,j,initial_color,newColor,image,visited):
        if visited[i][j]:
            return
        visited[i][j] = True
        image[i][j] = newColor
        for row,col in [[i,j+1],[i+1,j],[i,j-1],[i-1,j]]:
            if row >= 0 and row < len(image) and col >= 0 and col < len(image[0]) and not visited[row][col]:
                if image[row][col] == initial_color:
                    self.dfs(row,col,initial_color,newColor,image,visited)
                    
        
        