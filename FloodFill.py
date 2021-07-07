'''
Solution
1.  The problem can be solved using one of the 3 methods (BFS using Queue or DFS using Stack or DFS using Recursion).
2.  Using a Queue, starting from source cell, fill the cells with same color as source cell with new color in level order
    way (BFS).
3.  In DFS (Iterative or Recursive), add the cells with same color as source cell to the Stack (or Recursive Stack) and
    fill those cells with new color.

Time Complexity:    O(m x n) in all 3 approaches
Space Complexity:   O(m x n) in all 3 approaches

--- Passed all testcases on Leetcode successfully for all three solutions.
'''


from collections import deque


class FloodFill_Queue(object):

    def __isValidCell(self, image, nRows, nCols, r, c, oldColor, newColor):
        #   check whether a cell is valid or not and also having the same color as the source cell
        if (r >= 0 and r < nRows and c >= 0 and c < nCols and image[r][c] == oldColor and oldColor != newColor):
            return True
        return False

    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        #   edge case check
        if (image == None or len(image) == 0):
            return image

        #   initializations
        nRows = len(image); nCols = len(image[0])

        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        #   save old color before changing source cell to new color
        oldColor = image[sr][sc]
        image[sr][sc] = newColor

        #   maintain a queue
        queue = deque([[sr, sc]])

        while (len(queue) > 0):

            #   pop the front cell in the queue
            frontCell = queue.popleft()

            #   add its children (4) to the queue if they are valid cells having same color as source cell
            for direction in directions:
                r = frontCell[0] + direction[0]
                c = frontCell[1] + direction[1]
                if (self.__isValidCell(image, nRows, nCols, r, c, oldColor, newColor)):
                    image[r][c] = newColor
                    queue.append([r, c])

        #   return the updated image
        return image


class FloodFill_Recursion(object):

    def __init__(self):

        #   initialize all required global variables

        self.directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        self.nRows = 0
        self.nCols = 0
        self.oldColor = -1
        self.newColor = -1
        self.image = []

    def __isValidCell(self, r, c):
        #   check whether a cell is valid or not and also having the same color as the source cell
        if (r >= 0 and r < self.nRows and c >= 0 and c < self.nCols and self.image[r][c] == self.oldColor and
                self.oldColor != self.newColor):
            return True
        return False

    def __floodFillHelper(self, row, col):

        #   base case
        if (not self.__isValidCell(row, col)):
            return

        #   update the cell to new color
        self.image[row][col] = self.newColor

        #   recursion on all 4 directions
        for direction in self.directions:
            newRow = row + direction[0]
            newCol = col + direction[1]
            self.__floodFillHelper(newRow, newCol)

        return

    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        #   edge case check
        if (image == None or len(image) == 0):
            return image

        #   initializations
        self.nRows = len(image);  self.nCols = len(image[0])

        #   save old color before changing source cell to new color
        self.newColor = newColor
        self.oldColor = image[sr][sc]
        # image[sr][sc] = self.newColor
        self.image = image

        #   call helper function on source cell to start with
        self.__floodFillHelper(sr, sc)

        return self.image


class FloodFill_Stack(object):

    def __isValidCell(self, image, nRows, nCols, r, c, oldColor, newColor):
        #   check whether a cell is valid or not and also having the same color as the source cell
        if (r >= 0 and r < nRows and c >= 0 and c < nCols and image[r][c] == oldColor and oldColor != newColor):
            return True
        return False

    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        #   edge case check
        if (image == None or len(image) == 0):
            return image

        #   initializations
        nRows = len(image); nCols = len(image[0])
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        #   save old color before changing source cell to new color
        oldColor = image[sr][sc]

        #   maintain a stack
        stack = deque([[sr, sc, 0]])

        while (len(stack) > 0):

            #   extract the top cell in the stack
            topNode = stack[-1]
            topCount = topNode[2]
            image[topNode[0]][topNode[1]] = newColor

            #   explore entire depth in all 4 directions
            if (topCount < 4):

                stack[-1][2] += 1

                newRow = topNode[0] + directions[topCount][0]
                newCol = topNode[1] + directions[topCount][1]

                if (self.__isValidCell(image, nRows, nCols, newRow, newCol, oldColor, newColor)):
                    stack.append([newRow, newCol, 0])

            #   pop the top cell once its entire depth in all 4 directions is explored
            elif (topCount == 4):
                stack.pop()
        #   return the updated image
        return image