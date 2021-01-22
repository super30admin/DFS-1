class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        '''
        Time Complexity: O(mn)
        Space Complexity: O(mn)
        '''
        if(image[sr][sc]==newColor):
            return image
        directions = [(0,1),(0,-1),(1,0),(-1,0)]
        q = deque([(sr,sc)])
        oldColor = image[sr][sc]
        image[sr][sc]=newColor
        while(len(q)>0):
            e = q.popleft()
            for i in directions:
                r = e[0] + i[0]
                c = e[1] + i[1]
                if(r>=0 and c>=0 and r<len(image) and c<len(image[0]) and image[r][c]==oldColor):
                    image[r][c] = newColor
                    q.append((r,c))
        return image
