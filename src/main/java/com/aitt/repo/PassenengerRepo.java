package com.aitt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aitt.entity.PassengerInfo;

@Repository
public interface PassenengerRepo extends JpaRepository<PassengerInfo, Integer> {

}
