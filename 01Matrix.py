// Time Complexity : O(V+E)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution:
    def updateMatrix(self, A: List[List[int]]) -> List[List[int]]:
        R, C = len(A), len(A[0])
        q = deque()
        for r in range(R):
            for c in range(C):
                if not A[r][c]:
                    q.append((r, c))
                else:
                    A[r][c] = float('inf')
        while q: #perform BFS
            r, c = q.popleft()
            d = A[r][c] + 1
            for nr, nc in ((r+1, c), (r-1, c), (r, c+1), (r, c-1)): 
                if 0 <= nr < R and 0 <= nc < C and A[nr][nc] > d: #update d in new matrix
                    A[nr][nc] = d
                    q.append((nr, nc)) # append in queue for BFS
        return A #return final matrix