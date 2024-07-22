import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Main class to run the text-based music playlist application.
 */
public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        initializeAlbums();

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);  // There is no track 24

        play(playList);
    }

    /**
     * Initializes the albums with songs.
     */
    private static void initializeAlbums() {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Let's go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);
    }

    /**
     * Plays the playlist of songs.
     *
     * @param playList the playlist of songs
     */
    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.isEmpty()) {
            System.out.println("No songs in the playlist.");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            System.out.println("Enter your choice: ");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    playNextSong(listIterator);
                    break;
                case 2:
                    playPreviousSong(listIterator);
                    break;
                case 3:
                    replayCurrentSong(listIterator, forward);
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    deleteCurrentSong(listIterator);
                    break;
                default:
                    System.out.println("Invalid action. Please select a valid option.");
                    printMenu();
                    break;
            }
        }
    }

    private static void playNextSong(ListIterator<Song> listIterator) {
        if (listIterator.hasNext()) {
            System.out.println("Now playing " + listIterator.next().toString());
        } else {
            System.out.println("We have reached the end of the playlist.");
        }
    }

    private static void playPreviousSong(ListIterator<Song> listIterator) {
        if (listIterator.hasPrevious()) {
            System.out.println("Now playing " + listIterator.previous().toString());
        } else {
            System.out.println("You are at the start of the playlist.");
        }
    }

    private static void replayCurrentSong(ListIterator<Song> listIterator, boolean forward) {
        if (forward) {
            if (listIterator.hasPrevious()) {
                System.out.println("Now playing " + listIterator.previous().toString());
                listIterator.next();  // Move iterator back to current song
            } else {
                System.out.println("We are at the start of the list.");
            }
        } else {
            if (listIterator.hasNext()) {
                System.out.println("Now playing " + listIterator.next().toString());
                listIterator.previous();  // Move iterator back to current song
            } else {
                System.out.println("We have reached the end of the list.");
            }
        }
    }

    private static void deleteCurrentSong(ListIterator<Song> listIterator) {
        if (!listIterator.hasNext() && !listIterator.hasPrevious()) {
            System.out.println("No songs to remove.");
        } else {
            listIterator.remove();
            if (listIterator.hasNext()) {
                System.out.println("Now playing " + listIterator.next());
            } else if (listIterator.hasPrevious()) {
                System.out.println("Now playing " + listIterator.previous());
            }
        }
    }

    /**
     * Prints the menu of available actions.
     */
    private static void printMenu() {
        System.out.println("Available actions:\nPress");
        System.out.println("0 - to quit\n" +
                           "1 - to play the next song\n" +
                           "2 - to play the previous song\n" +
                           "3 - to replay the current song\n" +
                           "4 - to list songs in the playlist\n" +
                           "5 - to print available actions\n" +
                           "6 - to delete the current song from the playlist");
    }

    /**
     * Prints the list of songs in the playlist.
     *
     * @param playList the playlist of songs
     */
    private static void printList(LinkedList<Song> playList) {
        System.out.println("==================");
        for (Song song : playList) {
            System.out.println(song);
        }
        System.out.println("==================");
    }
}
