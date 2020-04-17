"""
// Time Complexity : O(m*n) 
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Ending recursion
// Your code here along with comments explaining your approach
Algorithm explanation
DFS
- Idea is to run DFS on sr,sc in the matrix and update the value of all 
the values that have 1
"""

class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        def dfs(i,j,matrix,m,n,origColor):
            matrix[i][j] = newColor

            directions = [(1,0),(0,1),(-1,0),(0,-1)]
            for x,y in directions:
                valx = x + i
                valy = y + j
                #We need to move only to elements having orig and new color different or else recursion will be endless
                if valx >=0 and valx < m and valy >=0 and valy < n and matrix[valx][valy] == origColor:#and newColor != origColor:
                    dfs(valx,valy,matrix,m,n,origColor)
        
        if not image or not image[0] or image[sr][sc] == newColor: #-> this was essentially to avoid back and forth and image won't change
            return image

        m = len(image)
        n = len(image[0])
        
        dfs(sr,sc,image,m,n,image[sr][sc])
        return image