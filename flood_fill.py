# Time Complexity :
# O(M*N)

# Space Complexity :
# O(M*N)

# Did this code successfully run on Leetcode :
#Yes

#We store the initial color of the pixel at the required location. We then run DFS from that pixel location
#Every time we visit a location, we check if it's already the required color, then we are done and we return as we have already visited this node
#If the color at the location is same as orignal important pixel location, then it needs to be updated and so do their neighbours - so we update the current pixel and iterate over it's neighbours

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        self.starting_colour = image[sr][sc]
        #image[sr][sc] = color
        self.dfs(sr,sc,image,color)
        return image

    def dfs (self,r,c,image,color):
        if image[r][c] == color :
            return
        if image[r][c] == self.starting_colour:
            image[r][c] = color
        else :
            return
        neighbours = [(1,0),(-1,0),(0,1),(0,-1)]
        for neighbour in neighbours:
            x = r + neighbour[0]
            y = c + neighbour[1]
            if self.is_valid_coord(x,y,len(image),len(image[0])) :
                self.dfs(x,y,image,color)

    def is_valid_coord(self,x,y,size_x,size_y):
        if x < 0 or x >= size_x :
            return False
        if y < 0 or y >= size_y :
            return False
        return True
