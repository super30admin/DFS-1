class Solution:
    # Time Complexity:O(m*n)
    # Space Complexity:O(m*n)
    def floodFill(
        self, image: List[List[int]], sr: int, sc: int, color: int
    ) -> List[List[int]]:
        m = len(image)
        n = len(image[0])
        oldColor = image[sr][sc]
        if not image:
            return image
        if image[sr][sc] == color:
            return image
        dirs = [[-1, 0], [0, -1], [0, 1], [1, 0]]
        q = []
        image[sr][sc] = color
        q.append(sr)
        q.append(sc)
        while q:
            currR = q.pop(0)
            currC = q.pop(0)
            for j in dirs:
                nr = currR + j[0]
                nc = currC + j[1]
                if (
                    nr >= 0
                    and nc >= 0
                    and nr < m
                    and nc < n
                    and image[nr][nc] == oldColor
                ):
                    image[nr][nc] = color
                    q.append(nr)
                    q.append(nc)
        return image
