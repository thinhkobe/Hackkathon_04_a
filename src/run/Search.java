package run;

import service.SingerService;
import service.SongService;

import java.awt.*;
import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        SingerService singerService=new SingerService();
        SongService songService=new SongService();

        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("*********************SEARCH-MANAGEMENT************************\n" +
                    "1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại . [5 điểm]\n" +
                    "2.Tìm kiếm ca sĩ theo tên hoặc thể loại [5 điểm]\n" +
                    "3.Hiển thị danh sách bài hát theo thứ tự tên tăng dần [5 điểm]\n" +
                    "4.Hiển thị 10 bài hát được đăng mới nhất [10 điểm]\n" +
                    "5.Thoát\n");
            System.out.println("nhập lựa chọn");
            int choice= Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                   songService.findBySingerName(sc);

//                case 2:
//                    while (true){
//                        System.out.println("nhập lựa chọn ");
//                        System.out.println("(1)tìm theo tên ca sĩ" +
//                                "(2)tìm theo thể loại");
//                        System.out.println("nhập lựa chọn");
//                        int choice1= Integer.parseInt(sc.nextLine());
//                        switch (choice1){
//                            case 1:findBySingerName();
//                                break;
//                            case 2:findByGenre();
//                        }
//                    }
//                    break;
            }
        }
    }
}
