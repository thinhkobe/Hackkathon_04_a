package controller;

import service.SingerService;
import service.SongService;

import java.util.Scanner;

public class SongController {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        SongService service=new SongService();
        while (true){
            System.out.println("**********************SONG-MANAGEMENT*************************\n" +
                    "1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới (có validate dữ\n" +
                    "liệu nhập vào) \n" +
                    "2.Hiển thị danh sách tất cả bài hát đã lưu trữ \n" +
                    "3.Thay đổi thông tin bài hát theo mã id \n" +
                    "4.Xóa bài hát theo mã id \n" +
                    "5.Thoát\n");
            int choice= Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    service.addSong(sc);
                    break;
                case 2:
                    service.displayAll();
                    break;
                case 3:
                    service.updateById(sc);
                    break;
                case 4:
                    service.deleteById(sc);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("nhập sai giá trị");
            }
        }
    }
}
