package com.board.model;

import com.board.model.BoardDTO;
import com.board.model.CommentDTO;

import java.util.ArrayList;

public interface SBoardDAO {
    void boardInsert(BoardDTO boardDTO);

    ArrayList<BoardDTO> findAll();

    void boardUpdate(BoardDTO board);

    void boardDelete(int num);

    BoardDTO findByNum(int num);

    int getBoardCount();

    ArrayList<BoardDTO> findAll(int startRow, int endRow);

    int getBoardCount(String field, String word);

    ArrayList<CommentDTO> findAllComment();
}
