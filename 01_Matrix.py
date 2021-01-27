# Created by Aashish Adhikari at 12:26 PM 1/27/2021

'''
Time Complexity:
O(m.n) + O(m.n) for the initial for loop and the BFS traversal of all the nodes.

Space Complexity:
O(m * n) in the worst case where all elements in the matrix are 0 and we add all of them to the queue before the dfs operation.
'''

class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """


        if len(matrix) == 0:
            return []

        from collections import deque
        bfs_q = deque()

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):

                if matrix [i][j] == 1:

                    # mark as unvisited
                    matrix[i][j] = -1

                if matrix[i][j] == 0:

                    # append row and col

                    bfs_q.append((i,j))



        dirs = [[-1,0], [1,0], [0,-1], [0,1]]
        dist = 0

        while len(bfs_q) != 0:

            dist += 1
            for idx in range(0,len(bfs_q)):

                x, y = bfs_q[0][0] , bfs_q[0][1] # col

                for dir in dirs:

                    r = x + dir[0]
                    c = y + dir[1]

                    if r >= 0 and c >= 0 and r < len(matrix) and c < len(matrix[0]):

                        if matrix[r][c] == -1:

                            matrix[r][c] = dist


                            bfs_q.append((r,c))

                # pop a co-ordinate
                bfs_q.popleft()

        return matrix




