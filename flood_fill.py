#Time Complexity :  O(mn)
#Space Complexity : O(mn)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no


class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        m = len(image)
        n = len(image[0])
        color = image[sr][sc]
        if color==newColor:
            return image
        
        dirs = [[0,-1],[0,1],[-1,0],[1,0]]
        def dfs(r,c):
            image[r][c] = newColor

            for item in dirs:
                r1 = r+item[0]
                c1 = c+item[1]
                if (r1>=0 and r1<m) and (c1>=0 and c1<n) and (image[r1][c1]==color):
                    dfs(r1,c1)

            
            
            
        dfs(sr,sc)
        return image