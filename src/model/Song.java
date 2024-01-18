package model;

import service.SingerService;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    // Constructors
    public Song() {
        this.createdDate = new Date(); // Thời gian hệ thống
    }

    public Song(String songId, String songName, String descriptions, Singer singer,
                String songWriter, boolean songStatus) {
        this(); // Gọi constructor mặc định để có thời gian tạo mặc định
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.songStatus = songStatus;
    }

    // Getter and Setter methods
    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    // Phương thức nhập thông tin từ bàn phím
    public void inputData(Scanner sc) {
        System.out.println("Nhập thông tin bài hát:");

        System.out.print("Mã bài hát (4 ký tự, bắt đầu bằng S): ");
        setSongId(sc.nextLine());

        System.out.print("Tên bài hát: ");
        setSongName(sc.nextLine());

        System.out.print("Mô tả: ");
        setDescriptions(sc.nextLine());

        // Hiển thị danh sách ca sĩ cho người dùng chọn
        System.out.println("Danh sách ca sĩ:");
        SingerService service=new SingerService();
        Singer[] singerlist= service.getListSingger();
        for (int i = 0; i < singerlist.length; i++) {
            System.out.println("ca sĩ thứ"+i+"id :"+singerlist[i].getSingerId()+"\n"+"tên ca sĩ"+singerlist[i].getSingerName());
        }

        System.out.print("Chọn mã ca sĩ: ");
        int singerId = Integer.parseInt(sc.nextLine());

        // Kiểm tra xem mã ca sĩ có tồn tại không
        boolean singerExists = false;
        for (Singer singer : singerlist) {
            if (singer.getSingerId()==singerId) {
                setSinger(singer);
                singerExists = true;
                break;
            }
        }

        // Nếu mã ca sĩ không tồn tại, yêu cầu người dùng thêm ca sĩ trước
        if (!singerExists) {
            System.out.println("Mã ca sĩ không tồn tại. Bạn cần thêm ca sĩ trước.");
            // Thêm ca sĩ tại đây hoặc chuyển quyền kiểm soát tới phương thức khác
        }

        System.out.print("Người sáng tác: ");
        setSongWriter(sc.nextLine());

        // Không nhập createdDate vì nó được tạo tự động
        // Bạn có thể chấp nhận mặc định hoặc cho người dùng cơ hội cập nhật ngày tạo

        System.out.print("Trạng thái bài hát (true/false): ");
        setSongStatus(Boolean.parseBoolean(sc.nextLine()));
    }

    // Phương thức hiển thị thông tin bài hát
    public void displayData() {
        System.out.println("Thông tin bài hát:");
        System.out.println("Mã bài hát: " + getSongId());
        System.out.println("Tên bài hát: " + getSongName());
        System.out.println("Mô tả: " + getDescriptions());
        System.out.println("Ca sĩ: " + getSinger().getSingerName()); // Hiển thị tên ca sĩ thay vì đối tượng ca sĩ
        System.out.println("Người sáng tác: " + getSongWriter());
        System.out.println("Ngày tạo: " + getCreatedDate());
        System.out.println("Trạng thái: " + isSongStatus());

    }

    @Override
    public String toString() {
        return "Song{" +
                "songId='" + songId + '\'' +
                ", songName='" + songName + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", singer=" + singer +
                ", songWriter='" + songWriter + '\'' +
                ", createdDate=" + createdDate +
                ", songStatus=" + songStatus +
                '}';
    }
}