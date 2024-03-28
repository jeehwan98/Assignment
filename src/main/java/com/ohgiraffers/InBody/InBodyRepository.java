package com.ohgiraffers.InBody;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class InBodyRepository {

    @PersistenceContext
    EntityManager manager;
    public void save(Member member) {
        manager.persist(member);    // persist! 저장이요~
    }
}
