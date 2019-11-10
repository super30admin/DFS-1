#Leetcode(733) : Successful

class Solution:
    def floodFill(self, image, sr, sc, newColor):
        #base case
        if image == None or len(image)==0:
            return 0
        color = image[sr][sc]
        #base case
        # call dfs if the source != newColor
        if color != newColor:
            self.dfs(image,sr,sc,color,newColor)

        return image

    def dfs(self,image,sr,sc,color,newColor):
        #base case
        if(sr<0 or sr>=len(image) or sc <0 or sc>=len(image[0]) or image[sr][sc] != color):
            return
        #set the newColor
        image[sr][sc] = newColor
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        #reccursive dfs call to the neighbours
        for dir in dirs:
            i = sr +dir[0]
            j = sc + dir[1]
            self.dfs(image,i,j,color,newColor)

obj = Solution()
print(obj.floodFill([[1,1,1],[1,1,0],[1,0,1]],1,1,2))
