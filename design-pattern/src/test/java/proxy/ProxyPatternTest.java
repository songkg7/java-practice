package proxy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;
import proxy.domain.Board;

class ProxyPatternTest {

    @Test
    void test_1() {
        StopWatch stopWatch = new StopWatch("Proxy test");
        stopWatch.start("Proxy 인스턴스 생성시간");
        Board board = getBoardFromDatabase();
        stopWatch.stop();

        System.out.println("Proxy 인스턴스 생성(sec) : " + stopWatch.getTotalTimeSeconds());

        System.out.println("실제 Board 인스턴스에 접근");
        stopWatch.start("실제 Board 인스턴스에 접근");
        board.getReplies().forEach(reply -> System.out.println(reply.getContent()));
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }

    private static Board getBoardFromDatabase() {

        int boardId = 1;
        List<Reply> replies = new ArrayList<>();
        //Proxy 객체로 replies 초기화
        for (int i = 0; i < 10; i++) {
            replies.add(new ReplyProxy(i + 1, boardId, "댓글 " + (i + 1)));
        }

        return new Board(boardId, "게시글1", "게시글입니다.", replies);
    }

}