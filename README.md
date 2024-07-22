# Music Playlist Manager

## Overview

Music Playlist Manager is a Java application that allows users to manage music albums and create playlists. Users can add songs to albums, create and manage playlists, and navigate through songs using a text-based interface.

## Features

- **Album Management**: Create albums and add songs to them.
- **Playlist Management**: Add songs to playlists by track number or song title.
- **Playback Control**: Navigate through the playlist with commands to play the next song, previous song, replay the current song, and delete the current song from the playlist.
- **User Interaction**: Text-based interface for easy interaction and control.

## How to Play

1. **Start the Game**: Run the `Main` class to start the application.
2. **Navigate**: Use directional commands to control playback:
   - `1` to play the next song
   - `2` to play the previous song
   - `3` to replay the current song
   - `4` to list songs in the playlist
   - `5` to print available actions
   - `6` to delete the current song from the playlist
   - `0` to quit the application

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your computer.

### Installation

1. Clone the repository or download the source code.
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Ensure the JDK is correctly set up in your IDE.

### Running the Application

1. Compile and run the `Main` class.
2. Follow the on-screen instructions to manage your albums and playlists.

## Code Structure

- **Main.java**: Contains the main application logic and user interface.
- **Album.java**: Defines the Album class, including methods to add songs and manage playlists.
- **Song.java**: Defines the Song class, representing individual songs with title and duration.

## Example Usage

1. Initialize albums and add songs:
   ```java
   Album album = new Album("Stormbringer", "Deep Purple");
   album.addSong("Stormbringer", 4.6);
   album.addSong("Love don't mean a thing", 4.22);
   albums.add(album);
