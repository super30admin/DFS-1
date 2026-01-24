class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        queue<pair<int, int>> zeroes;
        int n = mat.size();
        int m = mat[0].size();

        vector<vector<int>> dist(n, vector<int>(m,INT_MAX));
        unordered_set<string> us;

        for (int i=0;i<mat.size();i++) {
            for (int j=0;j<mat[0].size();j++) {
                if (mat[i][j] == 0) {
                    zeroes.push({i,j});
                    dist[i][j] = 0;
                }
            }
        }

        auto getKeys = [](int x, int y) -> string {
            return to_string(x) + "," + to_string(y);
        };

        auto visited = [&](int x, int y) {
            string key = getKeys(x, y);
            if (us.find(key) == us.end()) {
                us.insert(key);
                return true;
            }
            return false;
        };

        auto isSafe = [&](int newX, int newY){
            if (newX >=0 && newY >=0 && newX < mat.size() && newY < mat[0].size()) {
                return true;
            }
            return false;
        };

        auto addAdjacent = [&](pair<int, int> p) -> void {
            vector<vector<int>> dirs = {{1,0}, {-1,0} ,{0, 1} , {0, -1}};
            for (int i=0;i<dirs.size();i++) {
                int newX = p.first + dirs[i][0];
                int newY = p.second + dirs[i][1];
                if (isSafe(newX, newY) && dist[newX][newY] > dist[p.first][p.second] + 1 && visited(newX, newY)) {
                    zeroes.push({newX, newY});
                    dist[newX][newY] = dist[p.first][p.second] + 1;
                }
            }
        };

        while (!zeroes.empty()) {
            pair<int, int> p = zeroes.front();
            zeroes.pop();

            addAdjacent(p);
        }

        return dist;
    }
};
