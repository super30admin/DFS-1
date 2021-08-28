class Solution:
    """
    Time complexity: O(r*c)
    Space complexity: O(1)
    """

    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image == None or len(image) == 0:
            return image

        if image[sr][sc] == newColor:
            return image

        oldColor = image[sr][sc]

        def recurr(image, i, j):
            directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
            image[i][j] = newColor

            for dir in directions:
                r = i + dir[0]
                c = j + dir[1]

                if r >= 0 and r < len(image) and c >= 0 and c < len(image[0]) and image[r][c] == oldColor:
                    recurr(image, r, c)

        recurr(image, sr, sc)
        return image
