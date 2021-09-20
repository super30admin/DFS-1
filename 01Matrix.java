// TIME: O(M*N)
// SPACE: O(M*N)
// SUCCESS on LeetCode

public class OIMatrix {
    public int[][] updateMatrix(int[][] mat) {
        answer = new int[mat.length][mat[0].length];
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Pair(i,j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 0) level++;
            for (int i = 0; i < size; i++) {
                Pair<Integer,Integer> pair = queue.poll();
                int r = pair.getKey();
                int c = pair.getValue();
                if (r+1 < mat.length && mat[r+1][c] == -1) {
                    mat[r+1][c] = level;
                    queue.add(new Pair(r+1,c));
                }
                
                if (c+1 < mat[0].length && mat[r][c+1] == -1) {
                    mat[r][c+1] = level;
                    queue.add(new Pair(r,c+1));
                }
                
                if (r-1 >= 0 && mat[r-1][c] == -1) {
                    mat[r-1][c] = level;
                    queue.add(new Pair(r-1,c));
                }
                
                if (c-1 >= 0 && mat[r][c-1] == -1) {
                    mat[r][c-1] = level;
                    queue.add(new Pair(r,c-1));
                }
            }
        }
        
        return mat;
    }
}
