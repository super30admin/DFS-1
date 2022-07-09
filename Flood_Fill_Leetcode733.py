class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:

        Rows = len(image)
        Cols = len(image[0])
        currColor = image[sr][sc]
        if currColor == color:
            return image
        visit = set()
        stack = [(sr, sc)]
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        while stack:
            u = stack.pop(0)
            visit.add(u)
            row, col = u[0], u[1]
            image[row][col] = color
            for dr, dc in directions:
                new_row = row + dr
                new_col = col + dc
                if (Rows > new_row >= 0) and (Cols > new_col >= 0) and image[new_row][new_col] == currColor:
                    stack.append((new_row, new_col))
        return image
'''
        # DFS Recursive
        # Time Complexity: O(N), where N is the number of pixels in the image.
        # Space Complexity: O(N), size of the implicit call stack when calling dfs.
        Rows = len(image)
        Cols = len(image[0])
        currColor = image[sr][sc]
        if color == currColor: # there is nothing to change
            return image 
        def dfs(self,r,c):
            directions = [(-1,0),(1,0),(0,-1),(0,1)]
            if image[r][c] == currColor:
                image[r][c] = color
                for dr,dc in directions:
                    row = dr + r
                    col = dc + c
                    if (row>=0 and row<Rows) and (col>=0 and col<Cols):
                        self.dfs(row,col)
                #if r >= 1: dfs(r-1, c)
                #if r+1 < Rows: dfs(r+1, c)
                #if c >= 1: dfs(r, c-1)
                #if c+1 < Cols: dfs(r, c+1)
        dfs(sr,sc)
        return image     
'''




