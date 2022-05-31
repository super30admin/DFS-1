#Time Complexity : O(M*N)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        queue = [[sr,sc]]
        color = image[sr][sc]
        if color == newColor:
            return image
        dirr = [[1,0],[0,1],[-1,0],[0,-1]]
        row = len(image)
        col = len(image[0])
        image[sr][sc] = newColor
        while queue:
            node = queue.pop()
            for i in dirr:
                r = node[0] + i[0]
                c = node[1] + i[1]
                if r >=0 and c>=0 and r<row and c<col and image[r][c] == color:
                    image[r][c] = newColor
                    queue.append([r,c])
                    
        return image
                