//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        
        if(image[sr][sc]==newColor){
            return image;
        }
        
        int color=image[sr][sc];
        fillColor(image,sr,sc,newColor,color);
        return image;
    }
    
    void fillColor(vector<vector<int>>& image, int sr, int sc, int newColor,int color){
        
        if(sr>=image.size() || sr<0 || sc<0 || sc>=image[0].size() || image[sr][sc]!=color){
            return;
        }
        
        image[sr][sc]=newColor;
        fillColor(image,sr+1,sc,newColor,color);
        fillColor(image,sr-1,sc,newColor,color);
        fillColor(image,sr,sc+1,newColor,color);
        fillColor(image,sr,sc-1,newColor,color);
    }
};