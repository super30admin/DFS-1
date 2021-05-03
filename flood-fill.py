class Solution:
    def floodFill(
        self, image: List[List[int]], sr: int, sc: int, newColor: int
    ) -> List[List[int]]:
        if image is None or len(image) == 0 or image[sr][sc] == newColor:
            return image
        m = len(image)
        n = len(image[0])
        self.color = image[sr][sc]
        self.dfs(image, sr, sc, newColor)
        return image

    def dfs(self, image: List[List[int]], sr: int, sc: int, newColor: int):
        if (
            sr < 0
            or sc < 0
            or sr == len(image)
            or sc == len(image[0])
            or image[sr][sc] != self.color
        ):
            return
        image[sr][sc] = newColor
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        for dirc in dirs:
            r = sr + dirc[0]
            c = sc + dirc[1]
            self.dfs(image, r, c, newColor)
