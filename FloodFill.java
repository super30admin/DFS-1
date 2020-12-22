class Solution:
#o(n) tc and o(1) spc
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image[sr][sc]==newColor:
            return image


        color=image[sr][sc]



        def fill_color( i, j):
            if i<0 or j<0 or  i >= len(image) or j>= len(image[0]) or  image[i][j]!=color  :
                return 

            image[i][j]=newColor

            fill_color(i+1,j)
            fill_color(i-1,j)
            fill_color(i,j+1)
            fill_color(i,j-1)

        fill_color(sr,sc)

        return image


        

    
