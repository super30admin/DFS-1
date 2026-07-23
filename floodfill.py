class Solution:
    def floodFill(self, image, sr, sc, color):
        rows = len(image)
        cols = len(image[0])

        oldColor = image[sr][sc]

        if oldColor == color:
            return image

        directions = [(1,0),(-1,0),(0,1),(0,-1)]

        def dfs(r, c):

            if r < 0 or c < 0 or r >= rows or c >= cols:
                return

            if image[r][c] != oldColor:
                return

            image[r][c] = color

            for dr, dc in directions:
                dfs(r + dr, c + dc)

        dfs(sr, sc)

        return image

    # TC = O(mxn)
    # SC = O(mxn)