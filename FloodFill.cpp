class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        vector<vector<bool>> visited(image.size(), vector<bool>(image[0].size(), false));
        bfs(image, sr, sc, visited, color, image[sr][sc]);
        return image;    
    }

    void bfs(vector<vector<int>>& image, int i, int j, vector<vector<bool>>& visited, int color, int value) {
        deque<vector<int>> q; 
        q.push_back({i,j});

        while(!q.empty()) {
            int r = q.front()[0];
            int c = q.front()[1];
            q.pop_front();
            if(r >= 0 && r < image.size() && c >= 0 && c < image[0].size()) {
                if(!visited[r][c]) {
                    visited[r][c] = true; 
                    if(image[r][c] == value) {
                        image[r][c] = color; 
                        q.push_back({r-1,c});
                        q.push_back({r+1,c});
                        q.push_back({r,c-1});
                        q.push_back({r,c+1}); 
                    }
                }
            }
        }
    }
};