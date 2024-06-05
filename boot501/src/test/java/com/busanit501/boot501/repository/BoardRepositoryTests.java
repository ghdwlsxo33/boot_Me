package com.busanit501.boot501.repository;

import com.busanit501.boot501.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
                    Board board = Board.builder()
                            .title("오늘 점심 뭐먹지?" + i)
                            .content("한식" + i)
                            .writer("홍진태" + (i % 10))
                            .build();

                    Board result = boardRepository.save(board);
                    log.info("추가한 번호 : " + result.getBno());
                }
        );
    }

    @Test
    public void testSelect() {
        Long bno = 100L;
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();
        log.info("조회 결과는 : " + board);
    }

    @Test
    public void testUpdate() {
        Long bno = 100L;
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();
        board.changeTitleAndContent("오늘 점심 안 먹을 꺼야","굶어야 겠다");
        boardRepository.save(board);
        log.info("수정 결과는 : " + board);
    }

    @Test
    public void testDelete() {
        Long bno = 100L;
        boardRepository.deleteById(100L);
        log.info("삭제 결과는 : 완료 되었다");
    }
}

