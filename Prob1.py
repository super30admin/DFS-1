# Time complexity : O(m*n), 
# Space complexity : O(m*n)

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, new_color: int) -> List[List[int]]: 
        # if not image or len(image) == 0:
        #     return image
        
        # if image[sr][sc]==new_color: return image #edge case -#edge case - reove this and run and then write it out EXPLAIN
        # m = len(image)
        # n = len(image[0])
        # old_color = image[sr][sc]
        # image[sr][sc] = new_color
        # q = deque()
        # q.append((sr, sc))
        # dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        
        # while q:
        #     r, c = q.popleft()
        #     image[r][c] = new_color #remove from q and udpate it.
        #     for d in dirs:
        #         nr = d[0] + r
        #         nc = d[1] + c
        #         if 0 <= nr < m and 0 <= nc < n and image[nr][nc] == old_color: 
                    
        #             q.append((nr, nc))
        
        # return image

        if not image or len(image) == 0:
            return image
        
        if image[sr][sc]==new_color: return image #edge case - reove this and run and then write it out EXPLAIN
        m = len(image)
        n = len(image[0])
        old_color = image[sr][sc]
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        def dfs(image,row,col,newcolor):
            #base
            if 0 >row or row==m or 0 >col or col==n or image[row][col]!= old_color: 
                return
            #logic
            image[row][col]=newcolor
            for d in dirs:
                nr = d[0] + row
                nc = d[1] + col
                dfs(image,nr,nc,newcolor)
        dfs(image,sr,sc,new_color)
        return image




    




        