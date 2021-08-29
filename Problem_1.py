class Solution:
    def __init__(self):
        self.dir = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        self.color = -1
        self.m = 0
        self.n = 0

    """
    BFS Approach
    TC - O(mxn)
    SC - O(mxn)
    """

    def approach1(self, image, sr, sc, nc):
        m = len(image)
        n = len(image[0])
        color = image[sr][sc]
        # q = []
        q.append([sr, sc])
        image[sr][sc] = nc
        while len(q) > 0:
            cur = q.pop(0)
            for d in self.dir:
                r = d[0] + cur[0]
                c = d[1] + cur[1]
                if r >= 0 and c >= 0 and r < m and c < n and image[r][c] == color:
                    q.append([r, c])
                    image[r][c] = nc
        return image

    """
    DFS Approach
    TC - O(mxn)
    SC - O(mxn)
    """

    def approach2(self, image, sr, sc, nc):
        if sr < 0 or sc < 0 or sr == self.m or sc == self.n or image[sr][sc] != self.color:
            return
        image[sr][sc] = nc
        for d in self.dir:
            r = d[0] + sr
            c = d[1] + sc
            self.approach2(image, r, c, nc)

    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image or newColor == image[sr][sc]:
            return image
        # return self.approach1(image,sr,sc,newColor)
        self.m = len(image)
        self.n = len(image[0])
        self.color = image[sr][sc]
        self.approach2(image, sr, sc, newColor)
        return image
