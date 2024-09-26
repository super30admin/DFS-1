'''
Iterative:
Time Complexity: O(m*n) row*column
Space Complexity: O(m*n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a result which contains the answer and start from the 0's. Add the 0's x,y into the queue. Once you
do that check if the current node+1< neighbours weight, if it is true then update the neighbours weight to the currentNode +1
and add the neighbor into the queue.
'''


class Solution:

    def isValid(self, m, n, row, col):
        return row >= 0 and row < m and col >= 0 and col < n

    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m = len(matrix)

        if m == 0:
            return matrix

        n = len(matrix[0])

        res = [[9999 for y in range(0, n)] for x in range(0, m)]

        queue = []

        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]

        for i in range(0, m):
            for j in range(0, n):

                if matrix[i][j] == 0:
                    res[i][j] = 0
                    queue.append((i, j))

        while len(queue) != 0:
            current = queue[0]
            queue = queue[1:]
            for i in range(0, 4):
                x = current[0] + dx[i]
                y = current[1] + dy[i]

                if self.isValid(m, n, x, y):

                    if (res[current[0]][current[1]]) + 1 < res[x][y]:
                        res[x][y] = res[current[0]][current[1]] + 1
                        queue.append((x, y))
        return res

