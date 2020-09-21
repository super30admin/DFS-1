# // Time Complexity : O(n*m)
# // Space Complexity : O(n*m)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach:
# given source coordinates, keep updating the old color using DFS using directions array
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        dirn = [[0,1], [1,0], [0,-1], [-1,0]]
        
        if image == None or len(image) == 0 or len(image[0])==0 or image[sr][sc]==newColor:
            return image
        
        
        self.recur(image, sr, sc, image[sr][sc], newColor, dirn)
        
        return image
        
    
    def recur(self, image, i, j, oldColor, newColor, dirn):
        
        image[i][j] = newColor
        
        for d in dirn:
            r = i + d[0]
            c = j + d[1]
            
            if r>=0 and r<len(image) and c>=0 and  c<len(image[0]) and image[r][c] == oldColor:
                self.recur(image, r, c, image[r][c], newColor, dirn)
        
        