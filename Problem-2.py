"""
Problem2 (https://leetcode.com/problems/01-matrix/)
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Example 1:
Input:

0 0 0


0 1 0


0 0 0

Output:

0 0 0


0 1 0


0 0 0

Example 2:
Input:

0 0 0


0 1 0


1 1 1

Output:

0 0 0


0 1 0


1 2 1

TIME- 0(n*m)
SPACE- 0(n*m)
LEETCODE - Yes

"""

#BFS convert all 1's to infiniti and append all zeros into queue
# start popping from queue and use directions array to
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if matrix == None or len(matrix) == 0:
            return matrix
        m = len(matrix)
        n = len(matrix[0])
        q = collections.deque()
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 1:
                    matrix[i][j] = float('inf')
                else:
                    q.append([i, j])    # when found 0 add the position to q

        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]      #direction array
        while q:                                           #traverse the tree
            size = len(q)
            for i in range(size):
                root = q.popleft()
                root_i = root[0]
                root_j = root[1]
                for direc in directions:
                    r = root_i + direc[0]
                    c = root_j + direc[1]
                          # current element matrix[root_i][root_j]
                        # new element matrix[r][c]
                    if r < m and r >= 0 and c < n and c >= 0 and matrix[root_i][root_j] + 1 < matrix[r][c]:
                        q.append([r, c])     #ADD TO QUEUE if matrix[root_i][root_j] + 1 (current dstance) < new distance

                        matrix[r][c] = matrix[root_i][root_j] + 1        # change the distance of new element
        return matrix


