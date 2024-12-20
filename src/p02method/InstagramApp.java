package p02method;

import java.util.Date;

public class InstagramApp {

    public static void main(String[] args) {
        // InstagramMain 객체 생성
        InstagramMain im = new InstagramMain("인스타 시작", new Date());

        // 게시물 출력
        im.displayPost();

        // 게시물 수정
        im.editPost("게시물 수정하였습니다.");
        im.displayPost();  // 수정된 게시물 출력
    }
}

// InstagramMain 클래스 정의
class InstagramMain {
    private String post;     // 게시물 내용
    private Date regDate;    // 게시물 등록 날짜

    // 생성자
    public InstagramMain(String post, Date regDate) {
        this.post = post;
        this.regDate = regDate;
    }

    // 게시물 내용과 등록 날짜를 출력하는 메서드
    public void displayPost() {
        System.out.println("Post: " + post);
        System.out.println("Posted on: " + regDate);
    }

    // 게시물 내용을 수정하는 메서드
    public void editPost(String newPost) {
        this.post = newPost;
        System.out.println("Post update: " + newPost);
    }
}
