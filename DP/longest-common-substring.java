
class Solution{

  
//       String str1="ABCBDFMNOP";
//       String str2="ACBDGMNOP";
      
//   System.out.println(lcs(str1,str2));
    

    
     public static String lcs(String s1, String s2){
    
    int l1=s1.length();
    int l2=s2.length();
    int memo[][] = new int[l1+1][l2+1];
    int max=0;
    int maxi=0;
    int maxj=0;
    for( int i=1;i<=l1;i++){
      for(int j=1;j<=l2;j++){
        if(s1.charAt(i-1)==s2.charAt(j-1)){
          memo[i][j]=memo[i-1][j-1]+1;
          if(memo[i][j]>max){
          max=memo[i][j];
            maxi=i;
            maxj=j;
           }
        }
      }
    }
    

    
//         for( int i=1;i<l1;i++){
//       for(int j=1;j<l2;j++){
//           System.out.print(memo[i][j]+" ");
//       }
//             System.out.println();
//         }
    
  
  }

public String printlcs(int maxi, int maxj,int memo[][]){
    StringBuilder sb = new StringBuilder();
    
    while(maxi>0&&maxj>0&&memo[maxi][maxj]!=0){
        sb.append(s1.charAt(maxi-1));
      maxi--;
      maxj--;
    }
  return sb.reverse().toString();
}
  
  
  //brute-force lcs
  
  public void lcs2(){
    
      int l1 = str1.length();
      int l2=str2.length();
      int start=0;
      int size=0;
      
      if(l1==0||l2==0){
          System.out.println("");
      }
      
      
      for(int i=0;i<l1;i++){
          int k=i;
          for(int j=0;j<l2;j++){
          if(str1.charAt(i)==str2.charAt(j)){
             while(k<l1&&j<l2&&str1.charAt(k)==str2.charAt(j)){
              k++;
              j++;
          } 
             if(j>0&&size<=k-i){
            start =i;
            size=k-i+1;
               }
          }
          
          }
          
      }

    System.out.println(str1.substring(start,start+size-1));
  }
  
}
