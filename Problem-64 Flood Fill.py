# 733. Flood Fill
# https://leetcode.com/problems/flood-fill/

# Logic: Use DFS from the source given. Push the source in the stack and when you pop the same, 
# check its neighbours if they are of the same color push them to the stack and update it in visited. 
# Also update that cell with the new color.

# Time Complexiety: O(n)
# Space Complexiety: O(n)

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        n = len(image)
        m = len(image[0])
        color = image[sr][sc]
        stack = [(sr,sc)]
        neighbours = [(0,1),(0,-1),(1,0),(-1,0)]
        image[sr][sc] = newColor
        visited = {(sr,sc)}
        
        while stack:
            row, col = stack.pop()
            
            for neighbour in neighbours:
                newRow = row + neighbour[0]
                newCol = col + neighbour[1]
                
                if 0 <= newRow < n and 0 <= newCol < m:
                    if image[newRow][newCol] == color and (newRow,newCol) not in visited:
                        stack.append((newRow,newCol))
                        visited.add((newRow,newCol))
                        image[newRow][newCol] = newColor
                        
        return image