class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image.at(sr).at(sc) == newColor){
            return image;
        }
        queue<pair<int,int>>Q;
        Q.push(make_pair(sr,sc));
        int old_col = image.at(sr).at(sc); 
        image.at(sr).at(sc) = newColor;
        pair<int,int>p1(0,1);
        pair<int,int>p2(1,0);
        pair<int,int>p3(0,-1);
        pair<int,int>p4(-1,0);
        
        vector<pair<int,int>>dirs{p1,p2,p3,p4};
        while(!Q.empty()){
            pair<int,int>temp = Q.front();
            Q.pop();
            for(pair<int,int> i:dirs){
                int r = temp.first + i.first;
                int c = temp.second + i.second;
                if(r<image.size() && r>=0 && c<image.at(0).size() && c>=0 && image.at(r).at(c) == old_col){
                    image.at(r).at(c) = newColor;
                    Q.push(make_pair(r,c));
                }
            }
        }
        return image;
    }
};