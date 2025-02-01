########## 0,1 matrix

# Time Complexity : O(e+v)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# perform bfs from each of the zeroes and add to queue if we encounter a -1. as we reach a -1 update the result to height +1. As we go through keep updating the levels


def find_nearest_0(matrix):
        if not matrix or not matrix[0]:
            return [[]]

        queue = []
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0: 
                    queue.append((i,j))
                else:
                    matrix[i][j] = -1
        
        level = 0
        while queue:
            for i in range(len(queue)):
                x, y = queue.pop(0)
                for dx,dy in [(x+1,y),(x,y+1),(x-1,y),(x,y-1)]:
                    if 0 <= dx < len(matrix) and 0 <= dy < len(matrix[0]) and matrix[dx][dy] == -1:
                        queue.append((dx,dy))
                        matrix[dx][dy] == 1
                        matrix[x][y] = level + 1
            level+=1
        return matrix
