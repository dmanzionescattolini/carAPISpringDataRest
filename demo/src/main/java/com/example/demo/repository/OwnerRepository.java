package com.example.demo.repository;


import com.example.demo.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
