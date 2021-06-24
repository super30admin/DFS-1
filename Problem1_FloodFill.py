'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 733. Flood Fill
# An image is represented by an m x n integer grid image where image[i][j] 
# represents the pixel value of the image.

# You are also given three integers sr, sc, and newColor. You should perform a
#  flood fill on the image starting from the pixel image[sr][sc].

# To perform a flood fill, consider the starting pixel, plus any pixels 
# connected 4-directionally to the starting pixel of the same color as 
# the starting pixel, plus any pixels connected 4-directionally to those 
# pixels (also with the same color), and so on. Replace the color of all 
# of the aforementioned pixels with newColor.

# Return the modified image after performing the flood fill.

#-----------------
# Time Complexity: 
#-----------------
# O(M * N) - M rows and N columns in the worst case
#------------------
# Space Complexity: 
#------------------
# O(M + N): Max size of stack is in the order of number of pixels on the border
#           of the image : 2M + 2N

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        self.image = image
        self.targetColor = image[sr][sc]
        self.newColor = newColor
        self.dirs = [[-1,0], [0,1], [1,0], [0, -1]]
        self.visited = set()
        if self.targetColor != self.newColor:
            self.floodFillHelper(sr, sc)
        
        
        return self.image
        
    
    def floodFillHelper(self, sr: int, sc: int) -> None:
        
        self.image[sr][sc] = self.newColor
        # print(f"visiting: [{sr}][{sc}]")
        for neighbor_dir in self.dirs:
            neighbor_r = sr + neighbor_dir[0]
            neighbor_c = sc + neighbor_dir[1]
            if (neighbor_r >= 0 and neighbor_r < len(self.image) \
                and neighbor_c >= 0 and neighbor_c < len(self.image[0])):

                if(self.image[neighbor_r][neighbor_c] == self.targetColor):
                    
                    self.floodFillHelper(neighbor_r, neighbor_c)
        
        
        # print(f"painted: [{sr}][{sc}], self.image[{sr}][{sc}] = {self.image[sr][sc]}")