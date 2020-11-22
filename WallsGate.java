/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * 1. -1 - A wall or an obstacle. 
 * 2. 0 - A gate. 
 * 3. INF - Infinity means an empty room. 
 * 
 * We use the value 2147483647 to represent INF as you may
 * assume that the distance to a gate is less than 2147483647. Fill each empty
 * room with the distance to its nearest gate. If it is impossible to reach a
 * gate, it should be filled with INF.
 * 
 * Idea:
 * Use breadth first search on the door, start off by adding the doors to queue, and then iterate in breadth first fashion,
 * updating the INF that we encounter in the way.
 * 
 * Space Complexity: O(mn)
 * Time Complexity: O(mn)
 * 
 * Leetcode Result: 
 * Runtime: 7 ms, faster than 65.81% of Java online submissions for Walls and Gates. 
 * Memory Usage: 38.5 MB, less than 100.00% of Java online submissions for Walls and Gates.
 */
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0)
            return;
        int n = rooms[0].length;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new Pair(i, j));
                }
            }
        }

        int[] dx = new int[] { -1, 0, 1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            Pair current = q.remove();
            for (int i = 0; i < 4; i++) {
                int x = current.x + dx[i];
                int y = current.y + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = rooms[current.x][current.y] + 1;
                    q.add(new Pair(x, y));
                }
            }
        }
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}