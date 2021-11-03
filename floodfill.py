
# Time Complexity : O(n) n = number of pixels in image
# Space Complexity : O(n) n = number of pixels in image
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        m,n = len(image),len(image[0])
        og_color = image[sr][sc]
        q = deque()
        q.append((sr,sc))
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        if image[sr][sc] == newColor:
            return image
        while q:
            row,column = q.pop()
            image[row][column] = newColor
            for i in dirs:
                #print("Hi")
                nr = row+i[0]
                nc = column+i[1]
                if 0<=nr<m and 0<=nc<n and image[nr][nc] == og_color:
                    #print(str(image[nr][nc]) + ' '+str(og_color))
                    #if image[nr][nc] == og_color:
                    q.append((nr,nc))
                        #print(q)
        return image
                        
