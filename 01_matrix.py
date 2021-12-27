class Solution(object):

    # T.C is O(mn)
    # S.C is O(mn)
    # All Test Cases passed in Leetcode

    from collections import deque
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        row_length = len(mat)
        column_length = len(mat[0])

        queue = deque()
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]

        # Add all elements with '0' into queue else make elements as '-1'
        for row in range(row_length):
            for column in range(column_length):
                if mat[row][column] == 0:
                    queue.append([row, column])

                else:
                    mat[row][column] = -1

        # In queue if element is '-1' add its up, bottom, right, left into queue and change the value to the current level in which it is processed
        while queue:
            process = queue.popleft()
            for dir_move in dirs:
                nr = process[0] + dir_move[0]
                nc = process[1] + dir_move[1]

                if nr >= 0 and nr < row_length and nc >= 0 and nc < column_length and mat[nr][nc] == -1:
                    mat[nr][nc] = mat[process[0]][process[1]] + 1
                    queue.append([nr, nc])
        return mat
