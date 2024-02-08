// https://leetcode.com/problems/greatest-common-divisor-of-strings/

class Solution {


// str1 = mGCD, str2 = nGCD, str1 + str2 = (m + n)GCD = str2 + str1

  public String gcdOfStrings(String str1, String str2) {

      return (str1 + str2).equals(str2 + str1 )? 
             str1.substring(0, 
             calcGCD(str1.length(),str2.length() ) )  :
             "";

  }


    public String gcdOfStrings2(String str1, String str2) {

        
        int l1 = str1.length();
        int l2 = str2.length();
      
        int gcd = calcGCD(l1,l2);

        String patt = str2.substring(0,gcd);

        boolean s1 = checkPatt(str2,patt);

        if(s1){
            s1 = checkPatt(str1,patt);
        }


    return s1?patt:"";
       
    }


    int calcGCD(int a, int b){

        while(b!=0){
           int tmp =b ;
            b = a%b;
            a = tmp;
        }

        return a;
    }


  // checks if s can be formed by concatinating p
    boolean checkPatt(String s, String p){
         int l1 = s.length();
         int l2 = p.length();  
         
         if(l1%l2 !=0){return false;}

/*
sol: 1
        int times = l1/l2;
        StringBuilder sb = new StringBuilder();
        while(times>0){
            sb.append(p);
            times--;
        }

        return sb.toString().equals(s);
*/

/*
       int i =0;
        for(char c: s.toCharArray()){
                if(p.charAt(i)!= c){return false;}
                i = (i+1)%l2;
        }

*/  

    for( int i =0 ; i< l1; i ++){
        if(s.charAt(i) != p.charAt(i%l2) ){return false;}

    }
        return true;

        }

    }
