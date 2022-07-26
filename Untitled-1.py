# Time Complexity :o(n)
# Space Complexit: o(n)
# #Did this code successfully run on Leetcode :
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        rows= len(image)#taking the length of the image as an input fo the row
        cols=  len(image[0])#taking the length of the first size of list in list.
        startPx = image[sr][sc]
        #storing the initial values of the image in another 2D array.
        def dfs(r, c):
            #base condition
            if r<0 or c<0 or r>=rows or c>=cols or image[r][c] != startPx:
                return
            # logic
            if image[r][c] != color:
                image[r][c] = color
                dfs(r+1, c)#updating the positions of the cell in all the 
                dfs(r-1, c)
                dfs(r, c+1)
                dfs(r, c-1)
                
            else:
                return 
        
        #returning the function        
        dfs(sr, sc)
        return image