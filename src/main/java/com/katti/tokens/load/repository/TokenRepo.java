package com.katti.tokens.load.repository;

import com.katti.tokens.load.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepo extends JpaRepository<Token,Long> {
}
