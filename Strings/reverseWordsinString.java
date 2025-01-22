class Solution {
    public String reverseWords(String s) {


        StringBuilder sb = new StringBuilder();
        //remove all spaces 
        //connvert to array of words
        String [] words = s.trim().split("\\s+");
        //back traverse and add words
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
        //if no space found add space
        if(i!=0) {sb.append(" ");}
        }
        return sb.toString();
    }
}