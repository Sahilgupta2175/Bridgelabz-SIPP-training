import java.util.*;

abstract class MediaPlayer {
    protected LinkedList<String> playlist;
    protected String currentMedia;
    protected boolean isPlaying;

    public MediaPlayer() {
        this.playlist = new LinkedList<>();
        this.currentMedia = null;
        this.isPlaying = false;
    }

    public abstract void playNext();

    public abstract void addMedia(String media);

    public abstract void removeMedia(String media);

    public abstract void displayPlaylist();
}

class Song {
    private String title;
    private String artist;
    private double duration;

    public Song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + duration + " min)";
    }
}

class MusicPlayer extends MediaPlayer {
    private LinkedList<Song> songQueue;
    private Song currentSong;
    private int totalSongs;

    public MusicPlayer() {
        super();
        this.songQueue = new LinkedList<>();
        this.currentSong = null;
        this.totalSongs = 0;
    }

    public void addSong(Song song) {
        songQueue.addLast(song);
        playlist.addLast(song.toString());
        totalSongs++;
        System.out.println("Added to queue: " + song);
    }

    public void addSongToFront(Song song) {
        songQueue.addFirst(song);
        playlist.addFirst(song.toString());
        totalSongs++;
        System.out.println("Added to front of queue: " + song);
    }

    @Override
    public void addMedia(String media) {
        String[] parts = media.split(" - ");
        if (parts.length == 3) {
            try {
                String title = parts[0];
                String artist = parts[1];
                double duration = Double.parseDouble(parts[2]);
                addSong(new Song(title, artist, duration));
            } catch (NumberFormatException e) {
                System.out.println("Invalid duration format. Use: Title - Artist - Duration");
            }
        } else {
            System.out.println("Invalid format. Use: Title - Artist - Duration");
        }
    }

    @Override
    public void playNext() {
        if (!songQueue.isEmpty()) {
            currentSong = songQueue.removeFirst();
            currentMedia = playlist.removeFirst();
            isPlaying = true;
            totalSongs--;
            System.out.println("Now Playing: " + currentSong);
        } else {
            System.out.println("Queue is empty. No songs to play.");
            isPlaying = false;
            currentSong = null;
        }
    }

    public void playPrevious() {
        if (currentSong != null) {
            songQueue.addFirst(currentSong);
            playlist.addFirst(currentSong.toString());
            totalSongs++;
            System.out.println("Moved current song back to queue: " + currentSong);
            currentSong = null;
            isPlaying = false;
        } else {
            System.out.println("No current song to move back.");
        }
    }

    @Override
    public void removeMedia(String media) {
        boolean removed = false;
        Iterator<Song> iterator = songQueue.iterator();
        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (song.getTitle().equalsIgnoreCase(media) || song.toString().contains(media)) {
                iterator.remove();
                playlist.remove(song.toString());
                totalSongs--;
                removed = true;
                System.out.println("Removed from queue: " + song);
                break;
            }
        }
        if (!removed) {
            System.out.println("Song not found in queue: " + media);
        }
    }

    public void shuffle() {
        List<Song> tempList = new ArrayList<>(songQueue);
        Collections.shuffle(tempList);
        songQueue.clear();
        playlist.clear();
        for (Song song : tempList) {
            songQueue.add(song);
            playlist.add(song.toString());
        }
        System.out.println("Playlist shuffled!");
    }

    public void skipToSong(String title) {
        Song foundSong = null;
        Iterator<Song> iterator = songQueue.iterator();
        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (song.getTitle().equalsIgnoreCase(title)) {
                foundSong = song;
                iterator.remove();
                playlist.remove(song.toString());
                totalSongs--;
                break;
            }
        }

        if (foundSong != null) {
            if (currentSong != null) {
                songQueue.addFirst(currentSong);
                playlist.addFirst(currentSong.toString());
                totalSongs++;
            }
            currentSong = foundSong;
            currentMedia = foundSong.toString();
            isPlaying = true;
            System.out.println("Skipped to: " + foundSong);
        } else {
            System.out.println("Song not found: " + title);
        }
    }

    @Override
    public void displayPlaylist() {
        System.out.println("\n=== Music Player Status ===");
        if (currentSong != null) {
            System.out.println("Currently Playing: " + currentSong);
        } else {
            System.out.println("Currently Playing: Nothing");
        }

        System.out.println("Queue (" + totalSongs + " songs):");
        if (songQueue.isEmpty()) {
            System.out.println("  Queue is empty");
        } else {
            int position = 1;
            for (Song song : songQueue) {
                System.out.println("  " + position + ". " + song);
                position++;
            }
        }
        System.out.println("========================\n");
    }

    public void clearQueue() {
        songQueue.clear();
        playlist.clear();
        totalSongs = 0;
        System.out.println("Queue cleared!");
    }

    public int getQueueSize() {
        return totalSongs;
    }

    public Song getCurrentSong() {
        return currentSong;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void pause() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Music paused.");
        } else {
            System.out.println("Music is not currently playing.");
        }
    }

    public void resume() {
        if (currentSong != null && !isPlaying) {
            isPlaying = true;
            System.out.println("Music resumed: " + currentSong);
        } else if (currentSong == null) {
            System.out.println("No song to resume. Use playNext() to start playing.");
        } else {
            System.out.println("Music is already playing.");
        }
    }
}

class VideoPlayer extends MediaPlayer {
    @Override
    public void playNext() {
        if (!playlist.isEmpty()) {
            currentMedia = playlist.removeFirst();
            isPlaying = true;
            System.out.println("Now Playing Video: " + currentMedia);
        } else {
            System.out.println("Video queue is empty.");
        }
    }

    @Override
    public void addMedia(String media) {
        playlist.addLast(media);
        System.out.println("Added video to queue: " + media);
    }

    @Override
    public void removeMedia(String media) {
        if (playlist.remove(media)) {
            System.out.println("Removed video: " + media);
        } else {
            System.out.println("Video not found: " + media);
        }
    }

    @Override
    public void displayPlaylist() {
        System.out.println("Video Queue: " + playlist);
    }
}

public class MusicPlaylistQueue {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        System.out.println("=== Music Playlist Queue Demo ===\n");

        player.addSong(new Song("Bohemian Rhapsody", "Queen", 5.55));
        player.addSong(new Song("Hotel California", "Eagles", 6.30));
        player.addSong(new Song("Stairway to Heaven", "Led Zeppelin", 8.02));
        player.addSong(new Song("Imagine", "John Lennon", 3.07));

        player.displayPlaylist();

        player.playNext();
        player.playNext();
        player.displayPlaylist();

        player.addSongToFront(new Song("Thunderstruck", "AC/DC", 4.52));
        player.displayPlaylist();

        player.skipToSong("Imagine");
        player.displayPlaylist();

        player.removeMedia("Hotel California");
        player.displayPlaylist();

        player.shuffle();
        player.displayPlaylist();

        player.pause();
        player.resume();

        System.out.println("\n=== Polymorphism Demo ===");
        MediaPlayer videoPlayer = new VideoPlayer();
        videoPlayer.addMedia("Action Movie 1");
        videoPlayer.addMedia("Comedy Movie 2");
        videoPlayer.displayPlaylist();
        videoPlayer.playNext();

        System.out.println("\n=== Adding songs via string format ===");
        player.addMedia("Sweet Child O Mine - Guns N Roses - 5.03");
        player.addMedia("Invalid Format Song");
        player.displayPlaylist();

        player.clearQueue();
        player.displayPlaylist();
    }
}
