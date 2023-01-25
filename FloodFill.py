#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
#Successfully ran on leetcode

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if len(image)==0 or image[sr][sc]==color:
            return image
        oldColor = image[sr][sc]
        image[sr][sc]=color
        dirs = [[-1,0],[1,0],[0,-1],[0,1]]
        rows = len(image)
        cols = len(image[0])
        queue = [[sr,sc]]
        while queue:
            curr = queue.pop(0)
            for i in dirs:
                row = curr[0]+i[0]
                col = curr[1]+i[1]
                if row>=0 and row<rows and col>=0 and col<cols and image[row][col]==oldColor:
                    image[row][col]=color
                    queue.append([row,col])
        return image
