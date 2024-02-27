# Time Complexity : O(M x N) where M is number of rows and N is number of cols
# Space Complexity : Max(M, N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach
# Approach : We can first iterate the matrix and mark all the 1's as '-1'
# Now we will put all the 0's in the queue and start BFS and whenever we encounter -1 that means it is
# not visited, We update the count then and there itself and put that into the queue.


from queue import Queue
from typing import List


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        dir_x = [1, -1, 0, 0]
        dir_y = [0, 0, 1, -1]
        max_row = len(mat)
        max_col = len(mat[0])
        _queue = Queue()
        for row in range(max_row):
            for col in range(max_col):
                if mat[row][col] == 0:
                    _queue.put((row, col))
                else:
                    mat[row][col] = -1
        while _queue.qsize() > 0:
            cur = _queue.get()
            for index in range(4):
                new_row = cur[0] + dir_x[index]
                new_col = cur[1] + dir_y[index]
                if new_row < 0 or new_col < 0 or new_row == len(mat) or new_col == len(mat[0]):
                    continue
                if mat[new_row][new_col] == -1:
                    mat[new_row][new_col] = mat[cur[0]][cur[1]] + 1
                    _queue.put((new_row, new_col))
        return mat

