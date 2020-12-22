//Time O(n) - n is number of pixels in the image
//Space O(n)

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        queue<pair<int,int>> q;
        int color = image[sr][sc]; 
        
        q.push(make_pair(sr,sc));
        vector<vector<int>> dir {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.empty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                pair<int,int> c = q.front();q.pop();
                image[c.first][c.second] = newColor;
                for(auto d:dir){
                    int x = c.first+d[0];
                    int y = c.second+d[1];
                    if(x<0 || x>=image.size() || y<0 || y>=image[0].size() || image[x][y] == newColor || image[x][y]!=color) continue;
                    q.push(make_pair(x,y));
                }
            }
        }
        
        return image;
    }
};