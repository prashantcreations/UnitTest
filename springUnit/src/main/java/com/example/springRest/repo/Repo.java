package com.example.springRest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Iteam;

@Repository
public interface Repo extends JpaRepository<Iteam,Integer> {

}
