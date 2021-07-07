'''
Solution:
1.  Initially, put all elements with value 0 in the queue and perform level order traversal on each cell in the queue
2.  While processing each valid cell having a value 1, update its value to the corresponding level which implies the
    nearest distance to its 0.
3.  Return the upadted matrix containing distances.

--- Passed all testcases on leetcode successfully

Time Complexity: O(m x n) and Space Complexity: O(m x n)
'''


from collections import deque


class NearestZero(object):

    def __isValid(self, matrix, r, c, nRows, nCols):
        #   check whether a cell is valid or not and also having the the value 1
        if (r >= 0 and r < nRows and c >= 0 and c < nCols and matrix[r][c] == 1):
            return True
        return False

    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        #   edge case check
        if (matrix == None and len(matrix) == 0):
            return matrix

        #   initializations
        nRows = len(matrix); nCols = len(matrix[0])
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        visited = [[False for c in range(nCols)] for r in range(nRows)]

        #   maintain a queue
        queue = deque()

        #   add all cells with value 0 to the queue and mark them visited
        for r in range(nRows):
            for c in range(nCols):
                if (matrix[r][c] == 0):
                    queue.append([r, c])
                    visited[r][c] = True

        level = 0

        while (len(queue) > 0):

            #   for each level in the matrix, maintain size as level is important
            size = len(queue)
            for i in range(size):

                #   update the cell in the queue with the number as level
                frontCell = queue.popleft()
                matrix[frontCell[0]][frontCell[1]] = level

                #   for each direction of the popped cell, check whether the cell is valid or not and add to the queue if valid
                for direction in dirs:
                    newRow = frontCell[0] + direction[0]
                    newCol = frontCell[1] + direction[1]

                    if (self.__isValid(matrix, newRow, newCol, nRows, nCols) and
                            not visited[newRow][newCol]):
                        queue.append([newRow, newCol])
                        visited[newRow][newCol] = True

            #   increment the level
            level += 1

        return matrix

