package com.collectors.wordfrequencycount;
import java.util.*;
import java.util.stream.Collectors;
public class WordCount {
public static void main(String[]args) {
	String paragraph="Java streams are powerful and Java streams make data processing easy";
	Map<String,Long>wordCount=Arrays.stream(paragraph.toLowerCase().split("\\s+"))
	              .collect(Collectors.toMap( word -> word, word -> 1L,Long::sum));
	System.out.println(wordCount);
	
}
}