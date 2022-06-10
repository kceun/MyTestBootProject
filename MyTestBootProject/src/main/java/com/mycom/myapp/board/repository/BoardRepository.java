package com.mycom.myapp.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycom.myapp.board.dto.BoardDTO;

@Repository
public interface BoardRepository extends JpaRepository<BoardDTO, Integer>{

}
