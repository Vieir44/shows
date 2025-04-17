package com.shows.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shows.Entity.Shows;

public interface ShowsRepository extends JpaRepository<Shows, Long> {

}
