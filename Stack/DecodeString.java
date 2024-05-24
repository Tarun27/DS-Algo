//https://leetcode.com/problems/decode-string/description/

class Solution {

    // stack sol

    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        Deque<Integer> numbers = new ArrayDeque<>();

        StringBuilder decoded = new StringBuilder();

        int l = s.length();
        for (int i = 0; i < l; i++) {

            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                numbers.push(count);
            } else if (c == '[') {
                System.out.println(" .  .   "+decoded.toString());

                if (decoded.length() > 0) {
                    stack.push(decoded.toString());
                    decoded.setLength(0);
                }else{
                    stack.push("[");
                }

            } else if (c == ']') {

                int n = numbers.pop();
                String str = decoded.toString();
                while (n > 1) {
                    n--;
                    decoded.append(str);
                }

                if (!stack.isEmpty()) {
                    String str2 = stack.pop();
                    if(!str2.equals("["))
                    decoded.insert(0, str2);
                }
            } else {
                decoded.append(c);
            }


        }

        return decoded.toString();

    }

}

// recursive soln

/**
 * public String decodeString(String s) {
 * 
 * int i[] = new int[1];
 * return decode(s,i);
 * }
 * 
 * public String decode(String s, int[] i){
 * int n = 0;
 * StringBuilder sb = new StringBuilder();
 * while(i[0]<s.length()){
 * char c = s.charAt(i[0]);
 * 
 * if(Character.isDigit(c) ){
 * n = n*10 + c-'0';//Character.getNumericValue(c);
 * }else if(c =='['){
 * i[0]++;
 * String tmp = decode(s,i);
 * System.out.println(tmp);
 * while(n>0){
 * n--;
 * sb.append(tmp);
 * }
 * }else if(c==']'){
 * return sb.toString();
 * }else{
 * sb.append(c);
 * }
 * 
 * i[0]++;
 * }
 * 
 * return sb.toString();
 * 
 * }
 */
