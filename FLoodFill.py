#TC: O(m x n)
#SC: O(m x n)

from collections import deque


class Solution(object):

    def __isValidCell(self, image, nRows, nCols, r, c, oldColor, newColor):
        if (r >= 0 and r < nRows and c >= 0 and c < nCols and image[r][c] == oldColor and oldColor != newColor):
            return True
        return False

    def floodFill(self, image, sr, sc, newColor):
        
        if (image == None or len(image) == 0):
            return image

        nRows = len(image); nCols = len(image[0])

        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        oldColor = image[sr][sc]
        image[sr][sc] = newColor

        queue = deque([[sr, sc]])

        while (len(queue) > 0):

            frontCell = queue.popleft()

            for direction in directions:
                r = frontCell[0] + direction[0]
                c = frontCell[1] + direction[1]
                if (self.__isValidCell(image, nRows, nCols, r, c, oldColor, newColor)):
                    image[r][c] = newColor
                    queue.append([r, c])

        return image


class FloodFill_Recursion(object):

    def __init__(self):


        self.directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        self.nRows = 0
        self.nCols = 0
        self.oldColor = -1
        self.newColor = -1
        self.image = []

    def __isValidCell(self, r, c):
        if (r >= 0 and r < self.nRows and c >= 0 and c < self.nCols and self.image[r][c] == self.oldColor and
                self.oldColor != self.newColor):
            return True
        return False

    def __floodFillHelper(self, row, col):

        if (not self.__isValidCell(row, col)):
            return

        self.image[row][col] = self.newColor

        for direction in self.directions:
            newRow = row + direction[0]
            newCol = col + direction[1]
            self.__floodFillHelper(newRow, newCol)

        return

    def floodFill(self, image, sr, sc, newColor):
        
        if (image == None or len(image) == 0):
            return image

        self.nRows = len(image);  self.nCols = len(image[0])

        self.newColor = newColor
        self.oldColor = image[sr][sc]
        self.image = image

        self.__floodFillHelper(sr, sc)

        return self.image


class FloodFill_Stack(object):

    def __isValidCell(self, image, nRows, nCols, r, c, oldColor, newColor):
        if (r >= 0 and r < nRows and c >= 0 and c < nCols and image[r][c] == oldColor and oldColor != newColor):
            return True
        return False

    def floodFill(self, image, sr, sc, newColor):
        if (image == None or len(image) == 0):
            return image

        nRows = len(image); nCols = len(image[0])
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        oldColor = image[sr][sc]

        stack = deque([[sr, sc, 0]])

        while (len(stack) > 0):

            topNode = stack[-1]
            topCount = topNode[2]
            image[topNode[0]][topNode[1]] = newColor

            if (topCount < 4):

                stack[-1][2] += 1

                newRow = topNode[0] + directions[topCount][0]
                newCol = topNode[1] + directions[topCount][1]

                if (self.__isValidCell(image, nRows, nCols, newRow, newCol, oldColor, newColor)):
                    stack.append([newRow, newCol, 0])

            elif (topCount == 4):
                stack.pop()
        return image