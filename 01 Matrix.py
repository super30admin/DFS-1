# Time Complexity : O(m*n)
# Space Complexity :O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        #Base case
        if matrix == None or len(matrix) == 0:
            return matrix
        
        queue = deque()
        m = len(matrix)
        n = len(matrix[0])
        
        # add to queue if it's 0 or else make -1
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    queue.append((i,j))
                else:
                    matrix[i][j] = -1
        # next level the dist we have to put is 1
        dist = 1
        while queue:
            queue_len = len(queue)
            for i in range(queue_len):
                curr = queue.popleft()
                directions = [(-1, 0), (0, 1), (1, 0), (0,-1)]
                for dir in directions:
                    r = curr[0] + dir[0]
                    c = curr[1] + dir[1]
                    # boundary check and  matrix[r][c] == -1 add to queue and make with dist value
                    if r>= 0 and c>= 0 and r < len(matrix) and c< len(matrix[0]) and matrix[r][c] == -1:
                        queue.append((r,c))
                        matrix[r][c] = dist
                        
            dist += 1
            
        return matrix
