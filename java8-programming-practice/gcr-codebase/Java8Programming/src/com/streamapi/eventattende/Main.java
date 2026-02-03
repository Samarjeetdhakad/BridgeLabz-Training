package com.streamapi.eventattende;
import java.util.*;
import java.util.stream.*;
public class Main {
	    public static void main(String[] args) {
	        List<Attendee> attendees=Arrays.asList( new Attendee("samarjeet"),new Attendee("suyash"), new Attendee("Neha"), new Attendee("Rohit"));
	        attendees.stream().forEach(attendee ->System.out.println( "Welcome to the event, " + attendee.getName() + "!" ) );
	    }
	}

