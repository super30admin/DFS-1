# Solution

# // Time Complexity : O(m*n) since in worst case we might have to change color for all the cells
# // Space Complexity : Amortized O(m*n) since we keep adding more indices, we can add 4 indices for each poped index
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Approach is to first change the sr,sc color. Save it in queue. Then, taking that as reference by popping it
# save the 4-directional cells(1 row and 1 column around main cell). Keep doing this till the queue is empty
# This makes sure we start from sr,sc cell and change the adjacent cells while also saving those, thus further
# updating cells connected to those

from collections import deque

def floodFill(image,sr,sc,color):
    indexQueue = deque()
    prevColor = image[sr][sc]
    rowLen = len(image)
    colLen = len(image[0])
    if color == image[sr][sc]:
        return image
    
    image[sr][sc] = color
    indexQueue.append([sr,sc])

    while indexQueue:
        rowCol = indexQueue.popleft()

        if rowCol[0] > 0 and image[rowCol[0]-1][rowCol[1]] == prevColor:
            image[rowCol[0]-1][rowCol[1]] = color
            indexQueue.append([rowCol[0]-1,rowCol[1]])

        if rowCol[1] > 0 and image[rowCol[0]][rowCol[1]-1] == prevColor:  
            image[rowCol[0]][rowCol[1]-1] = color     
            indexQueue.append([rowCol[0],rowCol[1]-1])   

        if rowCol[0]+1 < rowLen and image[rowCol[0]+1][rowCol[1]] == prevColor:
            image[rowCol[0]+1][rowCol[1]] = color
            indexQueue.append([rowCol[0]+1,rowCol[1]])
        
        if rowCol[1]+1 < colLen and image[rowCol[0]][rowCol[1]+1] == prevColor:
            image[rowCol[0]][rowCol[1]+1] = color
            indexQueue.append([rowCol[0],rowCol[1]+1])
    
    return image

if __name__ == "__main__":
    image = [[1,1,1],[1,1,0],[1,0,1]]
    sr = 1
    sc = 1
    color = 2

    # image = [[0,0,0],[0,0,0]]
    # sr = 0
    # sc = 0
    # color = 0

    print(floodFill(image,sr,sc,color))