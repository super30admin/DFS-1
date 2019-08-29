# Time Complexity : O(n)
# Space Complexity : Confused between O(n) and O(n^2). HELP NEEDED.......
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes. I think it is not an optimal solution


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        visited = set()
        queue = []
        rows = len(matrix)
        cols = len(matrix[0])

        def validindex_finder(r, c):
            for vr, vc in [(r - 1, c), (r + 1, c), (r, c - 1), (r, c + 1)]:
                if vr >= 0 and vr < rows and vc >= 0 and vc < cols:
                    yield vr, vc

        for r in range(rows):
            for c in range(cols):
                if matrix[r][c] == 0:
                    visited.add((r, c))
                    queue.append((r, c))

        while queue:
            r, c = queue.pop(0)

            for vr, vc in validindex_finder(r, c):
                if (vr, vc) not in visited:
                    matrix[vr][vc] = matrix[r][c] + 1
                    queue.append((vr, vc))
                    visited.add((vr, vc))
        return matrix

# Here I am maintaining a set of visited nodes and a queue. First all the nodes having value 0 are inserted into the
# queue. Now we will pop the elements from the queue and will check if it is not visited then its vlaue must have not
# been 0  and will increase its value by 1 and will insert it into the queue.