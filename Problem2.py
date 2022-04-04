# Time Complexity : O(row*col)
# Space Complexity : O(row*col)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        queue = []
        row = len(mat)
        col = len(mat[0])
        
        for i in range(row):
            for j in range(col):
                if mat[i][j] == 0:
                    queue.append((i,j))
                else:
                    mat[i][j] = -1
                    
        while queue:
            directions = [[0,1],[0,-1],[1,0],[-1,0]]
            node = queue.pop(0)
            for direction in directions:
                x_val = node[0] + direction[0]
                y_val = node[1] + direction[1]
                if len(mat) > x_val >= 0 and len(mat[0]) > y_val >=0:
                    if  mat[x_val][y_val] == -1:
                        mat[x_val][y_val] = mat[node[0]][node[1]] + 1
                        queue.append((x_val, y_val))

        return mat