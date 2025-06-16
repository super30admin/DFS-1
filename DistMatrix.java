import java.util.Queue;
import java.util.LinkedList;

public class DistMatrix {

    int [][] mat = {{0,0,0},{0,1,0},{1,1,1}};
    int m = mat.length;
    int n = mat[0].length;
    int [][] dirns = {{0,1},{1,0},{0,-1},{-1,0}};

    public void bfs() {
        int i, j;
        Queue<int []> q = new LinkedList<int []>();
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    int [] coords = new int[2];
                    coords[0] = i;
                    coords[1] = j;
                    q.add(coords);
                }
            }
        }
        int dist = 2;
        while (!q.isEmpty()) {
            int size = q.size();
            int k;
            for (k = 0; k < size; k++) {
                int [] v = q.poll();
                int l;
                for (l = 0; l < dirns.length; l++) {
                    int new_x = v[0] + dirns[l][0];
                    int new_y = v[1] + dirns[l][1];
                    if (new_x >= 0 && new_x < m && new_y >= 0 && new_y < n && mat[new_x][new_y] == 1) {
                        mat[new_x][new_y] = dist;
                        int [] coords1 = new int[2];
                        coords1[0] = new_x;
                        coords1[1] = new_y;
                        q.add(coords1);
                    }
                }
            }
            dist++; 
        }
    }
    
    public static void main(String[] args) {
        DistMatrix dm = new DistMatrix();
        dm.bfs();
        for (int i = 0; i < dm.mat.length; i++) {
            for (int j = 0; j < dm.mat[0].length; j++) {
                System.out.println(dm.mat[i][j]);
            }
        }        
    }
}
