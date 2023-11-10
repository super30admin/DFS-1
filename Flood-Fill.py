# Time Complexity - O(m + n)
# Space Complexity - O(m + n)

class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        starting=image[sr][sc]
        if starting==newColor:
            return image
        
        lr,lc=len(image),len(image[0])
        fills=[(sr,sc)]
        
        while fills:
            r,c=fills.pop()
            image[r][c]=newColor
            
            if lr>1:
                if 0<=r<lr-1:
                    if starting==image[r+1][c]:
                        image[r+1][c]=newColor
                        fills.append((r+1,c))
                if 0<r<=lr-1:
                    if starting==image[r-1][c]:
                        image[r-1][c]=newColor
                        fills.append((r-1,c))
            
            if lc>1:
                if 0<=c<lc-1:
                    if starting==image[r][c+1]:
                        image[r][c+1]=newColor
                        fills.append((r,c+1))
                if 0<c<=lc-1:
                    if starting==image[r][c-1]:
                        image[r][c-1]=newColor
                        fills.append((r,c-1))
                        
        return image