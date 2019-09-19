"""
The approach here is to first find the source image, then check if the 
adjacent images are of different colors from the new color, if so start changing the adjacent images 
to the new assigned color, and keep calling the dfs function on each of the changed image.
LeetCode - Running
TIme complexity - O(N)
space complexity - O(N)

"""
def floodFill(self, image, sr, sc, newColor):
    temp = image[sr][sc]
    adjacent_images = [[0,1],[1,0],[0,-1],[-1,0]]
    def dfs(image,newColor,i,j):
        
            image[i][j] = newColor
            for x,y in adjacent_images:
                newI = i + x
                newJ = j + y
                if newI >= 0 and newI < len(image) and newJ >= 0 and newJ < len(image[0]) and image[newI][newJ] == temp and image[newI][newJ] != newColor:
                    image[newI][newJ] = newColor
                    dfs(image,newColor,newI,newJ)
            return image
                          
    return dfs(image,newColor,sr,sc)

