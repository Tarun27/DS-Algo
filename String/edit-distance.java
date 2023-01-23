//https://leetcode.com/problems/edit-distance

class Solution {
    public int minDistance(String w1, String w2) {
        if (w1 == null || w1.length() == 0) return w2.length();
        if (w2 == null || w2.length() == 0) return w1.length();
        Integer arr[][] = new Integer[w1.length()][w2.length()];
        return disBU(w1,w2);
    }

//bottom up

    public int disBU(String w1, String w2){

    int arr[][] = new int[w1.length()+1][w2.length()+1];

    IntStream.range(0,w1.length()+1).forEach(i->arr[i][0]=i);
    IntStream.range(0,w2.length()+1).forEach(i->arr[0][i]=i);
    
    for(int i=1;i<=w1.length();i++){
        for(int j=1;j<=w2.length();j++){
            if(w1.charAt(i-1)==w2.charAt(j-1))
            arr[i][j] = arr[i-1][j-1];
            else{
                arr[i][j] = 1 + Math.min(Math.min(arr[i-1][j],arr[i][j-1]),arr[i-1][j-1]);
            }
        }
    }
    return arr[w1.length()][w2.length()];
    }


//top down

    public int disTD(String w1, String w2, int i, int j, Integer[][] arr){

        if(i>=w1.length()) return w2.length()-j;

        if(j>=w2.length()) return w1.length()-i;

        if(arr[i][j]!=null)return arr[i][j];

        if(w1.charAt(i)==w2.charAt(j)){
            i++;
            j++;
            arr[i][j] = dis(w1,w2,i,j);
            return  arr[i][j];
        }
    if(w1.charAt(i)!=w2.charAt(j)){
         arr[i][j] =  1+ Math.min(Math.min(dis(w1,w2,i+1,j), dis(w1,w2,i,j+1)), dis(w1,w2,i+1,j+1));
    }
                     return arr[i][j];
    }


    public int dis(String w1, String w2, int i, int j){

        if(i>=w1.length()) return w2.length()-j;

        if(j>=w2.length()) return w1.length()-i;

        if(w1.charAt(i)==w2.charAt(j)){
            i++;
            j++;
            return dis(w1,w2,i,j);
        }
    if(w1.charAt(i)!=w2.charAt(j)){
        return 1+ Math.min(Math.min(dis(w1,w2,i+1,j), dis(w1,w2,i,j+1)), dis(w1,w2,i+1,j+1));
    }
            return 0;
    }
}
