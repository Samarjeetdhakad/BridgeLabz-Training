package com.streamapi.stockprice;
import java.util.*;
import java.util.stream.*;
public class Main {
	    public static void main(String[] args) {
	        List<Stock> liveFeed = Arrays.asList(
	            new Stock("CAPGE", 3890.50),
	            new Stock("INFY", 1582.75),
	            new Stock("RELIANCE", 2940.10),
	            new Stock("HDFCBANK", 1645.30)
	        );
	        liveFeed.stream().forEach(stock -> System.out.println( "Stock: " + stock.getSymbol() + "  Price: " + stock.getPrice()));
	    }
	}

