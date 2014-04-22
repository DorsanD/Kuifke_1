/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kuifke_1.domain;
import java.io.Serializable;


/**
 *
 * @author Dorsan
 */
public class TrackBean implements Serializable {
    private int TrackId;
    private String Track_Name;
    private String Genre;
    private int Length;

    private int Artiest_ArtiestId;
    private String File_Location;
    private String Image_Location;

    public String getFile_Location() {
        return File_Location;
    }

    public void setFile_Location(String File_Location) {
        this.File_Location = File_Location;
    }

    public String getImage_Location() {
        return Image_Location;
    }

    public void setImage_Location(String Image_Location) {
        this.Image_Location = Image_Location;
    }

    
    
    public int getTrackId() {
        return TrackId;
    }

    public void setTrackId(int TrackId) {
        this.TrackId = TrackId;
    }

    public String getTrack_Name() {
        return Track_Name;
    }

    public void setTrack_Name(String Track_Name) {
        this.Track_Name = Track_Name;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public int getLength() {
        return Length;
    }

    public void setLength(int Length) {
        this.Length = Length;
    }

    public int getArtiest_ArtiestId() {
        return Artiest_ArtiestId;
    }

    public void setArtiest_ArtiestId(int Artiest_ArtiestId) {
        this.Artiest_ArtiestId = Artiest_ArtiestId;
    }

    @Override
    public String toString() {
        return "TrackBean{" + "TrackId=" + TrackId + ", Track_Name=" + Track_Name + ", Genre=" + Genre + ", Length=" + Length + ", Artiest_ArtiestId=" + Artiest_ArtiestId + ", File_Location=" + File_Location + ", Image_Location=" + Image_Location + '}';
    }


    

}
