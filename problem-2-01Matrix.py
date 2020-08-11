"""
Problem:
https://leetcode.com/problems/rotting-oranges/

Approach: BFS


1. initially iterate over the matrix and put the co-ordinates of all the 0s in the que, and make all the 1 as -1
2. maintain dist variable
3. now process the items of the queue, take out items of the queue one by one, find its neighbours if the neighbours have value -1, replace it wiht dist value
4. after processs a level, increment the dist variable and continue processsing the rest of the levels


"""

# Time Complexity : O(m*n) , m is rows, n is columns
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if matrix==None or len(matrix) == None:
            return matrix
        
        que = deque()
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    que.append((i,j))
                else:
                    matrix[i][j]=-1
        
        dist = 1
        directions = [[0,-1],[0,1],[1,0],[-1,0]]
        while(que):
            size = len(que)
            for i in range(size):
                cur = que.popleft()
                for direction in directions:
                    r = cur[0]+direction[0]
                    c = cur[1]+direction[1]
                    if( r>=0 and r<= (len(matrix)-1) and c>=0 and c<=(len(matrix[0])-1) and matrix[r][c]==-1):
                        matrix[r][c]= dist
                        que.append((r,c))
            dist+=1
        
        return matrix
            
        