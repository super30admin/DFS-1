from collections import deque
# Time Complexity: O(mxn)
# Space Complexity: O(mxn)
class Solution(object):
    def updateMatrix(self, mat):
        # Maintain visited matrix
        col_l = len(mat[0])
        row_l = len(mat)

        visited = [[-1 for i in range(col_l)] for j in range(row_l)]
        q = deque()
        dirc = [[-1, 0], [0, 1], [1, 0], [0, -1]]

        #         Get all the 0 in queue and mark them visited
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    q.append([i, j])
                    visited[i][j] = 0
        # Initialize current level one
        curr_level = 1
        #         Iterate over queue and here we will consider size of queue as we need to add after each level
        while q:
            size = len(q)

            for i in range(size):
                row, col = q.popleft()
                # get the element from queue and get all its children and only if it is
                # not visited then assign that child current level and add it to queue and mark as visited
                for d in dirc:
                    r = row + d[0]
                    c = col + d[1]

                    if len(mat) > r >= 0 and len(mat[0]) > c >= 0 and visited[r][c] == -1:
                        # print(r,c)
                        mat[r][c] = curr_level
                        visited[r][c] = 0
                        q.append([r, c])
            #             update current level after each level
            curr_level += 1

        #         return updated matrix
        return mat

        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
