package com.constructor.level1;

class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    HotelBooking() {
        this.guestName="Guest";
        this.roomType="Standard";
        this.nights=1;
    }

    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName=guestName;
        this.roomType=roomType;
        this.nights=nights;
    }

    HotelBooking(HotelBooking other) {
        this.guestName= other.guestName;
        this.roomType= other.roomType;
        this.nights =other.nights;
    }
    void displayBooking() {
        System.out.println("Guest Name: "+guestName);
        System.out.println("Room Type: "+roomType);
        System.out.println("Nights: "+nights);
    }

    
}
