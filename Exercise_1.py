# Time Complexity: O(m*n)
# Space Complexity: O(m*n) 
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No

class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        
        if image == None or len(image) == 0 or image[sr][sc] == color:
            return image
        
        dirs = [[0,1], [1,0], [0, -1], [-1, 0]]
        m = len(image)
        n = len(image[0])
        oldColor = image[sr][sc]
                
        def dfs(image, sr, sc):
            #base
            if sr<0 or sr==m or sc<0 or sc==n or image[sr][sc]!=oldColor:
                return
            
            #logic
            for dir in dirs:
                image[sr][sc] = color
                nr = dir[0]+sr
                nc = dir[1]+sc
                dfs(image, nr, nc)
                        
        dfs(image, sr, sc)
        
        return image