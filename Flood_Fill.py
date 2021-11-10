class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        parse_image = [[False for i in range(len(image[0]))] for j in range(len(image))]
        def dfs(x,y,prev_color):
            print(image[x][y],prev_color)
            
            if image[x][y] == prev_color and not parse_image[x][y]:
                image[x][y] = newColor
                parse_image[x][y] = True
            else:
                return
            
            if x-1 >= 0 :
                dfs(x-1,y,prev_color)
            if x+1 < len(image) :
                dfs(x+1,y,prev_color)
            if y + 1 < len(image[0]):
                dfs(x,y+1,prev_color)
            if y - 1 >= 0:
                dfs(x,y-1,prev_color)
                
        dfs(sr,sc,image[sr][sc])
        return image