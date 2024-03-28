package com.aitt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aitt.entity.PaymentInfo;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentInfo, Integer> {

}
