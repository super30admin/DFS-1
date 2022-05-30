//TC = O(MN)
//SC = O(M,N)

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        int m = image.size();
        int n = image[0].size();
        if(m==0) return {{}};
        vector<vector<int>> dirs = {{0,-1},{0,1},{-1,0},{1,0}};
        queue<pair<int,int>> q;
        int color = image[sr][sc];
        if(color == newColor) return image;
        image[sr][sc] = newColor;
        q.push({sr,sc});
        while(!q.empty()){
            pair<int,int> p = q.front(); q.pop();
            for(auto dir: dirs){
                int r = p.first + dir[0];
                int c = p.second + dir[1];
                if(r>=0 && c>=0 && r<m && c<n && image[r][c]==color){
                    image[r][c] = newColor;
                    q.push({r,c});
                }
            }
        }
        return image;
    }
};
