class Solution:
    def floodFill(
        self, image, sr, sc, color):
        start_color = image[sr][sc]
        if start_color == color:
            return image
        neighbours = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        self.dfs(sr, sc, color, image, neighbours, start_color)
        return image

    def dfs(self, cr, cc, target_color, image, neighbours, start_color):
        image[cr][cc] = target_color
        for x, y in neighbours:
            nr, nc = cr + x, cc + y
            if (
                0 <= nr < len(image)
                and 0 <= nc < len(image[0])
                and image[nr][nc] == start_color
            ):
                self.dfs(nr, nc, target_color, image, neighbours, start_color)
