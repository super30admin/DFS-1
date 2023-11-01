class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        # TIME : O(mn)
        # Space: O(mn)
        colorToFill = image[sr][sc]
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        # DFS Approach
        def dfs(x, y):
            if x < 0 or x >= len(image) or y < 0 or y >= len(image[0]) or image[x][y] != colorToFill or image[x][
                y] == color: return
            image[x][y] = color
            for r, c in directions:
                nr = x + r
                nc = y + c
                dfs(nr, nc)

        # BFS Approach
        def bfs(x, y):
            q = collections.deque([(x, y)])
            image[x][y] = color
            while q:
                r, c = q.popleft()
                for row, col in directions:
                    nr = r + row
                    nc = c + col
                    if nr >= 0 and nr < len(image) and nc >= 0 and nc < len(image[0]) and image[nr][nc] == colorToFill:
                        q.append((nr, nc))
                        image[nr][nc] = color

        if image[sr][sc] == color: return image
        bfs(sr, sc)
        return image


