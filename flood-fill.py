'''
Time Complexity : O(m*n) 
Space Complexity : O(m*n)
Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this :
I forgot to add this condition image[row][col]!=newColor while coding which took me lot of time.
Initially I started with recursive approach which tookme 2 hrs approx, but then I wanted to explicitly
handle the stack which takes total of 5 hrs for this question alone. 

Your code here along with comments explaining your approach:

Algorithm
Approach using explicit stack instead of recursion

1. Create a stack
2. Add the starting point of the matrix onto the stack and change its color to newColor
3. Since we can change the color of a pixel if it was the same color and comes in its 4 direction, we create a function called `nextCoordinates(r,c)` which takes a position and returns a list of valid directions where we can move next
4. Upon the next direction we check whether that cell was of oldColor and also it should not painted with newColor ie `image[row][col]==oldColor and image[row][col]!=newColor` as this condition helps us avoid adding already existing cells onto the stack  and probably end in an infinite stack length.
5.  When we get a desired position we push it onto the stack and change the color of the pixel.

'''



class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        self.R=len(image)
        self.C= len(image[0]) if self.R!=0 else 0
        
        stack=[]
        oldColor = image[sr][sc]
        stack.append((sr,sc))
        image[sr][sc] = newColor
        
        while stack:
            r,c = stack.pop()
            positions = self.nextCoordinates(r,c)
            for position in positions:
                row,col = position
                if image[row][col]==oldColor and image[row][col]!=newColor:
                    stack.append((row,col))
                    image[row][col] = newColor
        
        
        return image
    
    def nextCoordinates(self,r,c):
        nextPosition = ((r,c-1),(r,c+1),(r-1,c),(r+1,c))
        for position in nextPosition:
            row,col = position
            if 0<=row<self.R and 0<=col<self.C:
                yield position
        