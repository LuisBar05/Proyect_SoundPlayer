/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_1;

import java.io.Serializable;

public class SongMetadata implements Serializable {

    private int idSong;
    private String fileName, songTitle, albumName, artistName;

    public void setidSong(int idSong) {
        this.idSong = idSong;
    }

    public int getIdSong() {
        return idSong;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistNme() {
        return artistName;
    }

}
