#All TC passed on leetcode

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:

        #Time complexity - O(m.n)
        #Space complexity - O(m.n)

        #DFS approach:
        
        if image[sr][sc]==color:
            return image
        
        def helper(r,c,oldcolor):
            if r<0 or c<0 or r>=len(image) or c>=len(image[0]) or image[r][c]!=oldcolor:
                return
            image[r][c] = color
            for dr, dc in directions:
                helper(r+dr, c+dc, oldcolor)

        directions = [[1,0], [-1,0], [0,1], [0,-1]]
        helper(sr,sc, image[sr][sc])
        return image

#-----------------------------------------OR------------------------------------------
        
        #BFS approach:

        m = len(image)
        n = len(image[0])
        oldcolor = image[sr][sc]

        if image[sr][sc]==color:
            return image 

        image[sr][sc] = color
        queue = collections.deque()
        queue.append((sr,sc))

        directions = [[1,0], [-1,0], [0,1], [0,-1]]

        while queue:
            r, c = queue.popleft()
            for dr, dc in directions:
                nr = r + dr
                nc = c + dc
                if nr>=0 and nc>=0 and nr<m and nc<n and image[nr][nc]==oldcolor:
                    image[nr][nc] = color
                    queue.append((nr,nc))
        return image




       


        