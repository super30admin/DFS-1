#Time Complexity- O(m*n)
#Space Complexity- O(d) where d = min(m,n)

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        q = deque([])
        col = image[sr][sc]
        directions = [[-1,0], [0,1], [1,0], [0,-1]]
        if col == color:
            return image
        image[sr][sc] = color
        q.append((sr, sc))

        while len(q) != 0:
            curr = deque([])
            while len(q) != 0:
                sr,sc = q.popleft()
                for x in directions:
                    if sr+x[0] >= 0 and sr+x[0] < len(image) and sc+x[1] >= 0 and sc+x[1] < len(image[0]) and image[sr+x[0]][sc+x[1]] == col:
                        curr.append((sr+x[0], sc+x[1]))
                        image[sr+x[0]][sc+x[1]] = color
            
            q = curr


        return image

