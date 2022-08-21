# 542. 01 Matrix

'''
Leetcode all test cases passed: Yes
Solution:
    def updateMatrix(self, mat):
        m is no of rows in mat
        n is no of columns in mat
        Time Complexity: O(m * n) 
        Space Complexity: O(m * n)
'''
class Solution:
    def updateMatrix(self, mat):
        direction_x = [0,0,-1,1]
        direction_y = [-1,1,0,0]
        queue = collections.deque([]) 
        for row in range(len(mat)):
            for col in range(len(mat[0])):
                if mat[row][col] == 0:
                    queue.append([row,col])
                else:
                    mat[row][col] = -1 
        level = -1
        while queue:
            level += 1
            for i in range(len(queue)):
                x,y = queue.popleft()
                if mat[x][y] == -1:
                    mat[x][y] = level
                for x_off,y_off in zip(direction_x,direction_y):
                    if(  x + x_off < 0 or x+ x_off >= len(mat) or y+ y_off < 0 or y+ y_off >= len(mat[0]) or mat[x+x_off][y+y_off] == 0 or mat[x+x_off][y+y_off] != -1 ):
                        continue
                    queue.append([x + x_off,y + y_off])
                

        return mat
