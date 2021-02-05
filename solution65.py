#Time complexity:O(m+n)
#Space complexity:O(mn)

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if len(matrix)==0:                                              #if the matrix is empty return the matrix
            return matrix
        m=len(matrix)                                                   #obtain the number of rows and columns in the matrix
        n=len(matrix[0])
        d=deque()                                                       #create a deque in the matrix
        for i in range(m):                                              #in the matrix if the value at current position is 0 append its position to the queue else change it to -1
            for j in range(n):
                if matrix[i][j]==0:
                    d.append([i,j])
                else:
                    matrix[i][j]=-1
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]                               #initializing the 4 adjacent positions
        count=1                                                        #maintaining the distance variable
        while d:                                                        #while the queue is not empty
            l=len(d)                                                    #obtain the current length of the queue
            for i in range(l):                                          #for every element within the current length l
                curr=d.popleft()                                        #obtain the first elment in the queue
                for dr in dirs:                                         #find the adjacent positions 
                    r=curr[0]+dr[0]
                    c=curr[1]+dr[1]
                    if 0<=r<m and 0<=c<n and matrix[r][c]==-1:          #if the adjacent position is within the matrix and the valur at the position is -1
                        d.append([r,c])                                 #append the position to the queue
                        matrix[r][c]=count                              #add the current distance in that position
            count+=1                                                    #increment the distance count for every level
        return matrix                                                   #return the matrix