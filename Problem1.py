'''
Problem: Flood Fill
Time Complexity: O(m * n ), where n and m is rows and cols of image
Space Complexity: O(n) for recursion stack
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        Applied DFS
        if pixels are in bound then change the pixel
        return final image at the end    
'''

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        dirs=[(-1,0), (1,0), (0,-1), (0,1)]
        orig = image[sr][sc]
        if orig == color:
            return image

        def dfs(r, c, image, dirs, color, orig):
            #base
            if (r<0 or c<0 or r==len(image) or c==len(image[0]) or image[r][c]!=orig):
                return 

            #logic 
            image[r][c] = color
            for d in dirs:
                nr= r + d[0]
                nc= c + d[1]
                dfs(nr, nc, image, dirs, color, orig)

        dfs(sr, sc, image, dirs, color, orig)
        return image

        