#Time Complexity : O(M*N)), M being the length the matrix and N the width
#Space Complexity : O(M*N)), M being the length the matrix and N the width
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Initially did not consider the case where the recursion
#comes back to the same cell. Had to debug and then redo. 
#Your code here along with comments explaining your approach in three sentences only
'''Using DFS and a directions array, recurse through the entire matrix. At each point, if the value
has been arrived at, make negative. And at the same time, make value color if it is the original. 
'''
class Solution:
    def __init__(self):
        self.image = []

    def helper(self, row, col, color, directions, original):
        #stop recursion if out of bounds or already touched upon. 
        if row<0 or row>=len(self.image) or col<0 or col>=len(self.image[0]):
            return 
        elif self.image[row][col]<0:
            return
        else:
            # change original to color and to negative and recurse. 
            if self.image[row][col]==original:
                self.image[row][col]=color
                self.image[row][col] = -self.image[row][col]
                if self.image[row][col]==0:
                    self.image[row][col]=-2**16-1
                for d in directions:
                    self.helper(d[0]+row, d[1]+col, color, directions, original)
                    

    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        #initialize and call helper function. 
        directions = [[1,0],[-1,0],[0,1],[0,-1]]
        original = image[sr][sc]
        self.image = image
        self.helper(sr, sc, color, directions, original)

        #return the negative values back to positive values. 
        for i in range(len(image)):
            for j in range(len(image[0])):
                if image[i][j]<0:
                    if image[i][j]==-2**16-1:
                        image[i][j]=0
                    else:
                        image[i][j] = -image[i][j]

        return self.image