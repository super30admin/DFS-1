class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows = len(mat)
        cols = len(mat[0])
        q = collections.deque()

        visited = []
        for r in range(rows):
            row = []
            for c in range(cols):
                row.append(False)
            visited.append(row)
        
        for r in range(rows):
            row = []
            for c in range(cols):
                if mat[r][c] == 0:
                    q.append([r, c, 0])
                    visited[r][c] = True
        
        directions = [[-1,0], [1,0], [0,-1], [0,1]]

        result = []
        for r in range(rows):
            row = []
            for c in range(cols):
                row.append(0)
            result.append(row)

        while q:
            r,c,dist = q.popleft()
            result[r][c] = dist

            for direction in directions:
                new_r = r+direction[0]
                new_c = c+direction[1]

                if new_r >= 0 and new_r < rows and new_c >=0 and new_c < cols:
                    if not visited[new_r][new_c]:
                        visited[new_r][new_c] = True
                        q.append([new_r, new_c, dist+1])
        return result