package com.example.Player;

public class Song {
    // Исполнитель~~ Год издания~~ Жанр~~ Альбом~~
    String singer, genre, album;
    int relYear;
    Song(String singerS, String genreS, String albumS, int relYearS){
        singerS = singer;
        genreS = genre;
        albumS = album;
        relYearS = relYear;
    }
    String getSinger(){
        return singer;
    }
    String getGenre(){
        return genre;
    }
    String getAlbum(){
        return album;
    }
    int getRelYear(){
        return relYear;
    }
}
