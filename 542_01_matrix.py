from collections import deque


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        """
            https://leetcode.com/problems/01-matrix/
            // Time Complexity : O(mn)
            // Space Complexity : O(mn)
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                 - add all zeros to queue (no dependency)
                 - Normal level order traversal with size an dirs list
                        - if the element is with in the range and value is 1
                        - add to queue and change value to current - 1 * dist
                - Change all negative distances to positive
        """
        rows = len(matrix)
        cols = len(matrix[0])

        if not matrix or not rows:
            return matrix

        queue = deque()

        for row in range(rows):
            for col in range(cols):
                # no dependency, when an element is zero
                # we no need to calculate the distance
                # so start with that
                if matrix[row][col] == 0:
                    queue.append((row, col))

        # level order traversal
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        dist = 0
        while queue:
            size = len(queue)
            # all elements popped at the current level are one more distance
            # away from the previous nearest zero
            dist += 1
            for i in range(size):
                cur = queue.popleft()
                for dir in dirs:
                    row = dir[0] + cur[0]
                    col = dir[1] + cur[1]
                    if (row >= 0 and row < rows) and (col >= 0 and col < cols) and (matrix[row][col] == 1):
                        queue.append((row, col))
                        matrix[row][col] = -1 * dist

        # change all negative distances to positive
        for row in range(rows):
            for col in range(cols):
                matrix[row][col] = abs(matrix[row][col])

        return matrix
