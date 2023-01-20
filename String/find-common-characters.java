//https://leetcode.com/problems/find-common-characters/description/

class Solution {
    public List<String> commonChars(String[] words) {
            if(words.length==1){
                return List.of(words);
            }

            List<String> list = new ArrayList();

            int[] cnt  = new int[26];
            Arrays.fill(cnt,Integer.MAX_VALUE);

            for(int i=0;i<words.length;i++){
                char arr[] = new char[26];
                words[i].chars().forEach(c->arr[c-'a']++);
                IntStream.range(0,26).forEach(x-> cnt[x] = Math.min(arr[x],cnt[x]));
            }

            for(int i=0;i<26;i++){

                while(cnt[i]!=0){
                    list.add(Character.toString(i+'a'));
                    cnt[i]--;
                }
            }


           return list;
        
    }
}
