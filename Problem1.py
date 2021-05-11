## Problem1 (https://leetcode.com/problems/flood-fill/)


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image==None or len(image) ==0 or image[sr][sc]==newColor:
            return image
        q = []
        m = len(image)
        n = len(image[0])
        q.append(sr)
        q.append(sc)
        color = image[sr][sc]
        image[sr][sc] = newColor
        dir = [[0,1],[0,-1],[1,0],[-1,0]]
        while len(q)!=0:
            cr = q.pop(0)
            cc = q.pop(0)
            for i in dir:
                r = cr + i[0]
                c = cc + i[1]
                if r >= 0 and r < m and c>=0 and c<n and image[r][c]==color:
                    image[r][c] = newColor
                    q.append(r)
                    q.append(c)
        return image
    #Time Complexity: O(mn)
    #Space Complexity: O(mn)
    #Approach: bfs - traverse all the elements of the matrix using queue and directions. 