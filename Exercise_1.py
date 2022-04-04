    # Time Complexity : O(mn)
    # Space Complexity : O(mn)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No


class Solution(object):
    img_dir=[]
    color=''
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        if not image or image[sr][sc]==newColor:
            return image
        self.color = image[sr][sc]
        m = len(image)
        n = len(image[0])
        
        self.img_dir= [[0,1], [0, -1], [-1, 0], [1,0]]
        
        def dfs(image, i, j, newColor, m, n):
            # base case
            if (i<0 or j<0 or i==m or j==n or image[i][j]!= self.color):
                return
            
            # Logic
            image[i][j] = newColor
            for d in self.img_dir:
                r = i + d[0]
                c = j + d[1]
                dfs(image, r, c, newColor, m, n)
            
            
        dfs(image, sr, sc, newColor, m, n)
        return image
            