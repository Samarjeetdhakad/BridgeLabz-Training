package artexpo;

public class Main {

    public static void main(String[] args) {

        Artist[] artists = {new Artist("Amit", 45),new Artist("Neha", 10),new Artist("Rahul", 30), new Artist("Pooja", 20) };
       ArtExpo.insertionSort(artists);

        System.out.println("Artists sorted by registration time:");
        for (Artist a : artists) {
            System.out.println(a.name+"-" + a.registrationTime);
        }
    }
}
