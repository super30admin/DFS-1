#Time Complexity : O(N) where N is number of element
#Space Complexity : O(B) where B is min(number of row,numberof columns)

class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if len(matrix)==0:
            return
        Queue =[]
        dirs =[(0,-1),(-1,0),(1,0),(0,1)]
        distance = 1
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j]==0:
                    Queue.append([i,j])
                else:
                    matrix[i][j] = -1
        
        while len(Queue) >0:
            size = len(Queue)
            for j in range(size):
                curr = Queue.pop(0)
                for i in dirs:
                    r = curr[0] + i[0]
                    c = curr[1] + i[1]
                    if r >=0 and c>=0 and r <len(matrix) and c<len(matrix[0]) and matrix[r][c] == -1 :
                        matrix[r][c] = distance
                        Queue.append([r,c])
                        
            distance+=1
        return matrix
                            