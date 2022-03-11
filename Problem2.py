TC: O(m * n)
SC: O(m * n)

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image is None or len(image) == 0 or image[sr][sc] == newColor:
            return image

        queue = []
        m = len(image)
        n = len(image[0])

        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        color = image[sr][sc]

        image[sr][sc] = newColor
        queue.append([sr, sc])

        while queue:
            elem = queue.pop(0)

            for dir in dirs:
                nr = elem[0] + dir[0]
                nc = elem[1] + dir[1]

                if nr >= 0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == color:
                    image[nr][nc] = newColor
                    queue.append([nr, nc])

        return image


