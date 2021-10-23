# // Time Complexity : O(m*n) where m,n are the number of rows,cols of the matrix
# // Space Complexity : O(min(m,n)) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        rows = len(image)
        cols = len(image[0])
        directions = [[1,0],[0,1],[-1,0],[0,-1]]
        queue = deque()
        queue.append([sr,sc])
        oldColor = image[sr][sc]
        if oldColor == newColor: return image
        image[sr][sc] = newColor
        
        while queue:
            x,y = queue.popleft()
            for dx,dy in directions:
                if 0 <= x+dx < rows and 0 <= y+dy < cols and image[x+dx][y+dy] == oldColor:
                    image[x+dx][y+dy] = newColor
                    queue.append([x+dx,y+dy])
        return image