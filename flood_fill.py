# DFS SOlution
# TIme/Space complexity = O(m*n) 
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:

        m = len(image)
        n = len(image[0])
        start_color = image[sr][sc]
        pos = [[0,1],[1,0],[-1,0],[0,-1]]
        def dfs(image, nr, nc, start_color, color, m, n):
            if image[nr][nc] == color: 
                return

            image[nr][nc] = color

            for i, j in pos:
                r, c  = nr + i, nc + j
                if 0 <= r < m and 0 <= c < n and image[r][c] == start_color:
                    dfs(image, r, c, start_color, color, m, n)
        dfs(image, sr, sc, start_color, color, m, n)
        return image

 


# BFS Solution
	m = len(image)
	n = len(image[0])
	queue = deque([(sr,sc)])
	start_color = image[sr][sc]
	if start_color == color:
     		return image
 	pos = [[0,1],[1,0],[-1,0],[0,-1]]
	 image[sr][sc] = color
	 while queue:
     		i,j = queue.popleft()
     		for x,y in pos:
         		r,c = i + x, j + y
         		if 0 <= r < m and  0 <= c < n and image[r][c] == start_color:
             			image[r][c] = color
             			queue.append((r,c))
	 return image




