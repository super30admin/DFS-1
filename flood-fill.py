# Time Complexity: O(m*n) -> size of grid
# Space Complexity: O(m*n)
# Approach:
# Use BFS or DFS to explore all neighbors of the starting node. If the color is oldColor, change it to newColor
# More comments on both approaches in-line...
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        # Edge Case
        oldColor = image[sr][sc] 
        if oldColor == newColor:
            return image
        
        # Get neighboring cells
        def getNeighbors(r, c, ROW, COLUMN):
            for nr, nc in ((r-1, c), (r, c-1), (r+1, c), (r, c+1)):
                if 0 <= nr < ROW and 0 <= nc < COLUMN:
                    yield nr, nc
        # Using BFS
        # Initialize queue for bfs
        ROW = len(image)
        COLUMN = len(image[0])
        q = collections.deque()
        # Set color of starting node to newColor
        image[sr][sc] = newColor
        # Append starting node to BFS queue
        q.append((sr,sc))
        
        while q:
            r, c = q.popleft()
            for nr, nc in getNeighbors(r,c,ROW,COLUMN):
                if image[nr][nc] == oldColor: # Append neighbors that have oldColor
                    image[nr][nc] = newColor
                    q.append((nr,nc))
        return image