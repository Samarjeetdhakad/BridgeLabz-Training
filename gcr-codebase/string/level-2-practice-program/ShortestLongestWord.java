import java.util.Scanner;
public class ShortestLongestWord{
    public static String[]splitWords(String text){
        int wordCount=1;
        for(int i=0; i<text.length();i++){
            if(text.charAt(i) == ' '){
                wordCount++;
         }
        }

        String[]words=new String[wordCount];
        String word="";
        int index=0;

        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(ch!=' '){
                word += ch;
             }
			else{
                words[index++] = word;
                word = "";
         }
        }
        words[index] = word; 
        return words;
      }
    public static int findLength(String s) {
        int count = 0;
        try{
            while(true) {
                s.charAt(count);
                count++;
          }
        }
		catch(Exception e){
           
        }
        return count;
       }
    public static String[][] createWordLengthArray(String[] words){
        String[][]data= new String[words.length][2];

        for (int i=0;i<words.length;i++) {
            data[i][0]=words[i];
            data[i][1]=String.valueOf(findLength(words[i]));
      }
        return data;
   }
    public static int[] findShortestLongest(String[][] data){
        int minIndex =0;
        int maxIndex =0;
        for (int i=1; i<data.length;i++) {
            int len=Integer.parseInt(data[i][1]);
            if(len<Integer.parseInt(data[minIndex][1])){
                minIndex =i;
              }
            if (len>Integer.parseInt(data[maxIndex][1])){
                maxIndex =i;
         }
        }
        return new int[]{minIndex, maxIndex};
      }
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        String text =sc.nextLine();

        String[]words=splitWords(text);
        String[][]wordLengthData=createWordLengthArray(words);
        int[] result=findShortestLongest(wordLengthData);
        for(int i =0; i<wordLengthData.length;i++) {
            System.out.println(wordLengthData[i][0] + "\t" + wordLengthData[i][1]);
        }
        System.out.println( wordLengthData[result[0]][0]);
        System.out.println(wordLengthData[result[1]][0]);
   }
}
