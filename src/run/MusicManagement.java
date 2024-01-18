package run;

import controller.SingerController;
import controller.SongController;

import java.util.Scanner;

public class MusicManagement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("************************MUSIC-MANAGEMENT*************************\n" +
                    "1. Quản lý ca sĩ \n" +
                    "2. Quản lý bài hát \n" +
                    "3. Tìm kiếm bài hát \n" +
                    "4. Thoát");
            System.out.println("nhập lựa chọn");
            int choice= Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1 :
                    SingerController.main(args);
                    break;
                case 2 :
                    SongController.main(args);
                    break;
                case 3 :
                    Search.main(args);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("nhập sai lựa chọn");
            }

        }
    }
}
