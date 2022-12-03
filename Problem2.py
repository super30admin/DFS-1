#Time complexity: O(m*n)
#Space complexity: O(m*n)

#Accepted on Leetcode 

#Approach
#Use a BFS traversal approach, start with 0's in the queue
#Before starting note all the unprocessed notes (1's) by changing to -1
#Process by using BFS one by one and change neighbouring node to currentVal + 1


from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = deque()
        n = len(mat)
        m = len(mat[0])
        dirs = [[0,-1],[0,1],[-1,0],[1,0]]
        setCount = 0 #number of values to be set ie ones
        #first traverse and get all initial zeros
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0:
                    queue.append([i,j])
                else:
                    setCount += 1
                    mat[i][j] = -1

        #now start bfs
        while setCount < m*n:
            curNodeArr = queue.popleft()
            row = curNodeArr[0]
            col = curNodeArr[1]
            curVal = mat[row][col]
            for dirns in dirs:
                nr = row + dirns[0]
                nc = col + dirns[1]
                if nr >= 0 and nr < n and nc >= 0 and nc < m and mat[nr][nc] == -1:
                    mat[nr][nc] = curVal + 1 #making it neg to indicate marked
                    setCount -= 1
                    queue.append([nr,nc])
            if setCount == 0:
                break


        
        return mat




        
        


        


