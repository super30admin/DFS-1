# Time Complexity :  O(mn)
# Space Complexity : O(mn)

# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        i = j = 0
        number = image[sr][sc]
        q = []
        q.append((sr,sc))
        image[sr][sc] = color
        if number == color:
            return image

        while(len(q) > 0):
            (i,j) = q.pop(0)
            if i > 0 and image[i-1][j] == number:
                q.append((i-1,j))
                image[i-1][j] = color

            if i < len(image)-1 and image[i+1][j] == number:
                q.append((i+1,j))
                image[i+1][j] = color

            if j > 0 and image[i][j-1] == number:
                q.append((i,j-1))
                image[i][j-1] = color

            if j < len(image[0])-1 and image[i][j+1] == number:
                q.append((i,j+1))
                image[i][j+1] = color

        return image