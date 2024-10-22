# T.C = O(m * n) S.C = O(m * n)
class Solution(object):
    dirs = [(0,-1),(0,1),(-1,0),(1,0)]
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        self.m = len(image)
        self.n = len(image[0])
        oldColor = image[sr][sc]
        if(oldColor == color):
            return image
        self.dfs(image,sr,sc,color,oldColor)
        return image

    def dfs(self,image,i,j,color,oldColor):
        if(i<0 or j<0 or i==self.m or j==self.n or image[i][j] != oldColor):
            return
        image[i][j] = color
        for dir in self.dirs:
            r = i + dir[0]
            c = j + dir[1]
            if(r>=0 and c>=0 and r<self.m and c<self.n and image[r][c] == oldColor):
                self.dfs(image,r,c,color,oldColor)
        