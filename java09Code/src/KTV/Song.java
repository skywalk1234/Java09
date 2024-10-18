package KTV;

import java.io.Serializable;

public class Song implements Serializable {
    private String title;
    private String artist;
    private String genre;
    private int year;
    private int timesPlayed;
    //	利用注解或者自己创建构造器和get方法
    public Song(String title, String artist, String genre, int year, int timesPlayed) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.timesPlayed = timesPlayed;
    }//构造器
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }
    public String getInfo(){
        System.out.println("---------------------------------------");
        return "歌曲:"+title +"\n创作者:"+artist + "\n流派:"+genre + "\n发行时间:"+year + "\n时长:"+timesPlayed;
    }
    public String WriteIn(){
        //作为写入文件时候的格式
        return title+"\n"+artist+"\n"+genre+"\n"+year+"\n"+timesPlayed;
    }
    public void Readout(){

    }
}