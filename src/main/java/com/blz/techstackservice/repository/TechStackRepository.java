package com.blz.techstackservice.repository;

import com.blz.techstackservice.model.TechStackModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechStackRepository extends JpaRepository<TechStackModel, Integer> {
}
