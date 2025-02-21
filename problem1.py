'''
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    # BFS
    # def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
    #     ogColor = image[sr][sc]
    #     m = len(image)
    #     n = len(image[0])
    #     if ogColor == color:
    #         return image
    #     dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    #     q = collections.deque()
    #     image[sr][sc] = color
    #     q.append((sr, sc))
    #     while q:
    #         cr, cc = q.popleft()
    #         for dr, dc in dirs:
    #             nr = cr + dr
    #             nc = cc + dc
    #             if nr >= 0 and nr < m and nc >= 0 and nc < n and image[nr][nc] == ogColor:
    #                 q.append((nr, nc))
    #                 image[nr][nc] = color
    #     return image

    # DFS
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        ogColor = image[sr][sc]
        if ogColor == color:
            return image
        
        def dfs(nr, nc):
            nonlocal image, ogColor, color
            m = len(image)
            n = len(image[0])
            if nr < 0 or nr >= m or nc < 0 or nc >= n or image[nr][nc] != ogColor:
                return
            image[nr][nc] = color
            
            dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
            for dr, dc in dirs:
                r = nr + dr
                c = nc + dc
                dfs(r, c)

        dfs(sr, sc)      
        return image