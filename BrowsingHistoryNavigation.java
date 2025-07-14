/*
Scenario 1: Browser History Navigation
Use Case: Maintain a user’s browsing history with the ability to move back and forth.
Why LinkedList? Doubly linked list makes it easy to navigate both backward and forward.
OOP Concepts:
● Encapsulation: Browser history data is wrapped inside a class.
● Abstraction: Navigation methods hide internal implementation.
● Inheritance & Polymorphism: Reusable navigation for other apps like music players.
*/

public class BrowsingHistoryNavigation {
    public static class HistoryNode {
        String url;
        HistoryNode prev;
        HistoryNode next;

        public HistoryNode(String url) {
            this.url = url;
            this.prev = null;
            this.next = null;
        }
    }

    public static class BrowsingHistory {
        private HistoryNode current;

        public BrowsingHistory(String homePage) {
            this.current = new HistoryNode(homePage);
        }

        public void visitNewPage(String url) {
            HistoryNode newPage = new HistoryNode(url);
            current.next = null;
            newPage.prev = current;
            current.next = newPage;
            current = newPage;
        }

        public String moveBackward(int steps) {
            while (steps > 0 && current.prev != null) {
                current = current.prev;
                steps--;
            }
            return current.url;
        }

        public String moveForward(int steps) {
            while (steps > 0 && current.next != null) {
                current = current.next;
                steps--;
            }
            return current.url;
        }

        public String getcurrent() {
            return current.url;
        }
    }

    public static class MusicPlayerHistory extends BrowsingHistory {
        public MusicPlayerHistory(String song) {
            super(song);
        }

        @Override
        public void visitNewPage(String song) {
            System.out.println("Playing new song: " + song);
            super.visitNewPage(song);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Browser History ===");
        BrowsingHistory history = new BrowsingHistory("google.com");
        history.visitNewPage("youtube.com");
        history.visitNewPage("github.com");
        System.out.println("Back 1: " + history.moveBackward(1)); // youtube.com
        System.out.println("Back 1: " + history.moveBackward(1)); // google.com
        System.out.println("Forward 1: " + history.moveForward(1)); // youtube.com
        history.visitNewPage("stackoverflow.com");
        System.out.println("Current: " + history.getcurrent()); // stackoverflow.com
        System.out.println("Forward 2: " + history.moveForward(2)); // stackoverflow.com

        System.out.println("\n=== Music Player History ===");
        MusicPlayerHistory music = new MusicPlayerHistory("Intro.mp3");
        music.visitNewPage("Song1.mp3");
        music.visitNewPage("Song2.mp3");
        music.moveBackward(1); // goes to Song1
        music.visitNewPage("Song3.mp3"); // plays new song, clears forward history
    }
}