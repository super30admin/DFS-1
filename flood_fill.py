################## Iterative solution
# Time complexity: O(m*n)
# Space complexity: O(n*m)
# Worked on leetcode: yes
# Iterative approach: This algorithm uses a recursive solution. We first change the color of the given row, column in the image to the new color.
# And then recurse the solution for each neighboring element (if the element is 1).



class Solution:
    def __init__(self):
        self.dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]

    def floodFill(self, image, sr, sc, newColor):
        # self.image = image
        self.newColor = newColor

        if image == None or len(image) == 0 or len(image[0]) == 0:
            return image

        if image[sr][sc] == self.newColor:
            return image

        self.oldColor = image[sr][sc]
        self.recurse(image, sr, sc)

        return image

    def recurse(self, image, i, j):
        image[i][j] = self.newColor

        for direction in self.dirs:
            row = i + direction[0]
            col = j + direction[1]

            if (row >= 0 and row < len(image) and col >= 0 and col < len(image[0]) and image[row][
                col] == self.oldColor):
                self.recurse(image, row, col)


result = Solution()
print(result.floodFill([[1,1,1],[1,1,0],[1,0,1]], 1, 1, 2))