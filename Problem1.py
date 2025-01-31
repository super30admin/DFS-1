# "1. BFS: If it's already same color stop. Keep a temp old color variable and it's location. Append it's neighbours to queue if they are equal to temp old color and switch it to 2.
# 2. DFS: Start from the point and recursively go to 4 directions and check the color and change or return"
# TC: O(m x n)
# SC: O(m x n)
# Yes, this worked in leetcode

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        # Base case
        if image[sr][sc] == color or not image:
            return image
        m = len(image)
        n = len(image[0])
        rows = collections.deque()
        cols = collections.deque()
        oldColor = image[sr][sc]
        image[sr][sc] = color
        rows.append(sr)
        cols.append(sc)
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        while rows:
            curr_row = rows.popleft()
            curr_col = cols.popleft()
            for dir in dirs:
                nr = curr_row + dir[0]
                nc = curr_col + dir[1]
                if nr >= 0 and nr < m and nc >= 0 and nc < n and image[nr][nc] == oldColor:
                    image[nr][nc] = color
                    rows.append(nr)
                    cols.append(nc)
        return image
        
        
        
        
        
        
        
        
        # temp=image[sr][sc]
        # stack=[(sr,sc)]
        # while(stack):
        #     i,j=stack.pop()
        #     if(image[i][j]==temp):
        #         image[i][j]=color    
        #         if(i+1<len(image)):
        #             stack.append((i+1,j))
        #         if(i-1>=0):
        #             stack.append((i-1,j))
        #         if(j+1<len(image[0])):
        #             stack.append((i,j+1))
        #         if(j-1>=0):
        #             stack.append((i,j-1))
        #     else:
        #         pass
        # return image