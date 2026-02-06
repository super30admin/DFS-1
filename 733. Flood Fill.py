# Time: O(m*n)
# Space: O(m*n)

# BFS APPROACH

# Have a variable to know the initial color.
# If the initial color is the color to change then return the image as it is
# Then first change the color of the sr sc in the image.
# and then looping through the directions aray check if the adjacent element is equal to the initial color and add elements inside the q accordingly

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        q= deque([(sr,sc)])
        initialCol = image[sr][sc]
        if initialCol == color:
            return image
        image[sr][sc] = color

        while q:
            currR,currC = q.popleft()
            direc = [[1,0],[0,1],[-1,0],[0,-1]]
            for r,c in direc:
                nr = currR + r
                nc = currC + c
                if 0 <= nr < len(image) and 0 <= nc < len(image[0]):
                    if image[nr][nc] == initialCol:
                        image[nr][nc] = color
                        q.append((nr,nc))
        return image
    

# Time: O(m*n)
# Space: O(m*n)

# DFS APPROACH

# At the point where we did BFS earlier we'll do DFS choosing any element from sr,sc
# Hence in the DFS helper funciton go through the directions array and if the element is equal to initialCol then call DFS on that
# The base case will be handled by the loop that we have on the directions array

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        q= deque([(sr,sc)])
        initialCol = image[sr][sc]
        if initialCol == color:
            return image
        image[sr][sc] = color

        self.helper(image,sr,sc,color,initialCol)

        return image
    def helper(self,image,sr,sc,color,initialCol):
        direc = [[1,0],[0,1],[-1,0],[0,-1]]
        for r,c in direc:
            nr = sr + r
            nc = sc + c
            if 0 <= nr < len(image) and 0 <= nc < len(image[0]):
                if image[nr][nc] == initialCol:
                    image[nr][nc] = color
                    self.helper(image,nr,nc,color,initialCol)