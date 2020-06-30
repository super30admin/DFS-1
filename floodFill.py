#733. Flood Fill
# Time Complexity : O(m*n)
# Space Complexity :O(m*n)
# Did this code successfully run on Leetcode : Yes
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        if not image or image[sr][sc] == newColor:
            return image
        m = len(image)
        n = len(image[0])
        color = image[sr][sc]
        queue = []
        queue.append([sr,sc])
        image[sr][sc] = newColor
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        while queue:
            size = len(queue)       
            curr = queue.pop(0)
            for d in dirs:
                r = d[0] + curr[0]
                c = d[1] + curr[1]
                if r >= 0 and r < m and c >= 0 and c < n and image[r][c] == color:
                    image[r][c] = newColor
                    queue.append([r,c])
        return image

#dfs
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        if not image or image[sr][sc] == newColor:
            return image
        self.m = len(image)
        self.n = len(image[0])
        self.color = image[sr][sc]
        self.dfs(image,sr,sc,newColor)
        return image
    def dfs(self,image,sr,sc,newColor):
        if sr < 0 or sr == self.m or sc < 0 or sc == self.n or image[sr][sc] != self.color:
            return
        image[sr][sc] = newColor
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        #curr = image[sr][sc]
        for d in dirs:
            r = d[0] + sr
            c = d[1] + sc
            self.dfs(image,r,c,newColor)
