# Time Complexity : Brute Force: O(r.c)^2
# Space Complexity :: Brute Force O(1) 
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : Thinking the optimized solution


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                dist = float('inf')
                if matrix[i][j] == 1:
                    for k in range(len(matrix)):
                        for l in range(len(matrix[0])):
                            if matrix[k][l] == 0:
                                dist = min(dist, (abs(i-k)) + abs(j-l))
                                matrix[i][j] = dist
        return matrix