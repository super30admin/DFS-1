# Time Complexity : O(numRows * numCols)
# Space Complexity : O(numRows * numCols)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        if image[sr][sc] == newColor:
            return image
        
        numRows = len(image)
        numCols = len(image[0])
        oldColor = image[sr][sc]
        
        q = deque([ ])
        
        q.append((sr, sc))
        
        dirs = [(1,0),(-1,0),(0,1),(0,-1)]
        
        while q:
            row, col = q.popleft()
            image[row][col] = newColor
            for d in dirs:
                adjRow, adjCol = row + d[0], col + d[1]
                if 0 <= adjRow < numRows and 0 <= adjCol < numCols:
                    if image[adjRow][adjCol] == oldColor:
                        q.append((adjRow, adjCol))
                        
        return image