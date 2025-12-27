package com.constructor.level1;

public class HotelBookingMain{
	public static void main(String[] args) {

        HotelBooking b1 = new HotelBooking();
        HotelBooking b2 = new HotelBooking("Samar", "Deluxe", 3);
        HotelBooking b3 = new HotelBooking(b2);

        b1.displayBooking();
        b2.displayBooking();
        b3.displayBooking();
    }
}