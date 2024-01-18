package service;

import model.Singer;
import model.Song;

import java.util.Scanner;

public class SongService {
        Song[] songs=new Song[0];
        //thêm ca sĩ
        public void addSong(Scanner sc){
            System.out.println("nhập số bài hát cần thêm");
            int n= Integer.parseInt(sc.nextLine());
            Song[] newSongs=new Song[songs.length+n];
            for (int i = 0; i < songs.length; i++) {
                newSongs[i]=songs[i];
            }
            for (int i = 0; i <n; i++) {
                Song newSong=new Song();
                newSong.inputData(sc);
                newSongs[songs.length+i]= newSong;
            }
            songs= newSongs;
            System.out.println("danh sach");
            displayAll();
        }
        //hiển thị danh sách bài hát
        public void displayAll(){
            if (songs.length==0){
                System.out.println("danh sách rỗng");
            }else{
                for (int i = 0; i < songs.length; i++) {
                    songs[i].displayData();
                }
            }
        }
        //tìm vị trí theo id
        public int findIndex( int id) {
            int index = -1;
            for (int i = 0; i < songs.length; i++) {
                if (songs[i].getSongId().equals(id)){
                    index=i;
                };
            }
            return index;
        }
        //thay đổi thông tin bài hát theo id
        public void updateById(Scanner sc){
            System.out.println("nhập id ca sĩ cần thay đổi");
            int id= Integer.parseInt(sc.nextLine());
            int index=findIndex(id);
            if(index==-1){
                System.out.println("nhập sai id bài hát");
            }else{
                Song song=new Song();
                song.inputData(sc);
                songs[index]=song;
                System.out.println("đã thay đổi");

            }

        }
        public void deleteById(Scanner sc){
            System.out.println("nhập id ca sĩ cần xóa");
            int id= Integer.parseInt(sc.nextLine());
            int index=findIndex(id);
            if(index==-1){
                System.out.println("nhập sai id ca sĩ");
            }else{
                Song[] songs1=new Song[songs.length-1];
                for (int i = 0; i < songs.length; i++) {
                    if (i<index){
                        songs1[i]=songs[i];
                    }
                    if (i>index){
                        songs1[i-1]=songs[i];
                        System.out.println("xóa thành công");
                        displayAll();
                    }
                }

            }

        }
        //phương thức lấy danh sách tên bài hát
        public Song[] getListSingger(){
            return songs;
        }
        //phương thức tìm kiếm theo tên
    public void findBySingerName(Scanner sc){
        System.out.println("nhập tên cần tìm kiếm");
        String songName=sc.nextLine();
        for (int i = 0; i < songs.length; i++) {
            if(songs[i].getSongName().contains(songName)){

            }
        }

    }
    // phương thức tìm kiếm theo thể loại

    public void findByGenre(){

    }


    }


