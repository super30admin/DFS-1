from collections import deque
from typing import List

"""
BFS Approach
"""
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #Null case
        if grid==None or len(grid)==0 or grid[0]==0 or len(grid[0])==0:
            return 0

        m=len(grid)
        n=len(grid[0])
        self.fresh=0
        self.time=0
        q=deque()

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==2: #if orange is rotten, add it in queue
                    q.append((i,j))

                elif grid[i][j]==1: #if orange is fresh, increament fresh counter
                    self.fresh+=1

        if self.fresh==0:
            return 0

        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

        while q:
            #maintain siez variable to know if level is done, this is required to increase time, once level done
            size=len(q)
            #print("queue" , q)
            for i in range(size):
                #Original rotten orange we have already added in queue at first and we are popping them and checking
                #their neighbors here, if fresh orange is neighbor, we add it in queue as it will be rotten
                curr_element = q.popleft()  #pop element= row,column
                #pop current elements and go to its neighbors using directions array
                for direction in directions: #go to all directions of popped element
                    row=curr_element[0]+ direction[0]
                    column=curr_element[1]+ direction[1]
                    #checking bounds
                    if (row>=0 and column>=0 and row<m and column<n and grid[row][column]==1):
                        grid[row][column]=2
                        #this fresh orange will be rotten as it is a neighbor of original rotten orange, so mark it as rotten and add in queue
                        q.append((row,column))
                        self.fresh-=1
            self.time+=1 #level processing done, increasing time
            #print("t", self.time)

        if self.fresh!=0:
            return -1

        return self.time-1
#we are increasing time even after last level is done, oranges get rotten at last level, so return time-1

s=Solution()
print(s.orangesRotting([[2,1,1],[1,1,0],[0,1,1]]))