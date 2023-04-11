733. Flood Fill

:w

//BFS
class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
   
        int n = image.size();
        if (n == 0) return {{}};
        int m = image[0].size();
        
        int dirarry[4][2] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        queue<pair<int, int>> q;
        int orig =  image[sr][sc];
        if (orig == color) return image;

        q.push({sr, sc});
        image[sr][sc] = color;
        while(!q.empty()) {
                int cr = q.front().first;
                int cc = q.front().second;
                q.pop();
                for (int k=0; k<4; k++) {
                    int nr = cr + dirarry[k][0];
                    int nc = cc + dirarry[k][1];
                    if ((nr >=0) && (nc >=0) && (nr <n) && (nc < m)) {
                        if ((image[nr][nc] == orig)) {
                            q.push({nr,nc});
                            image[nr][nc] =  color;
                        }
                    }
                }
        }
        return image;
    }
};
