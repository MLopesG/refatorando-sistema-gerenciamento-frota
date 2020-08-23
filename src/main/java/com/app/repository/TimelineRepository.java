package com.app.repository;

import com.app.entity.Timeline;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimelineRepository extends JpaRepository<Timeline, Integer> {
    
}