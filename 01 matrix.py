# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q = deque()
        
        rMax, cMax = len(mat), len(mat[0])
        visiting, visited = set(), set()

        for r in range(rMax):
            for c in range(cMax):
                if mat[r][c] == 0:
                    q.append((r, c))
                    visiting.add((r, c))
        
        while q:
            for _ in range(len(q)):
                (r, c) = q.popleft()
                directions = [(+1, 0), (-1, 0), (0, +1), (0, -1)]
                for (dr, dc) in directions:
                    (nr, nc) = r + dr, c + dc
                    if nr < 0 or nc < 0 or nr >= rMax or nc >= cMax:
                        continue
                    if (nr, nc) in visiting:
                        continue
                    
                    mat[nr][nc] = 1 + mat[r][c]

                    visiting.add((nr, nc))
                    q.append((nr, nc))
        return mat