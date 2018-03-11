package com.impaqgroup.training.architecture.hexagonalarchitecture.repository;

import org.springframework.stereotype.Repository;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;
import com.impaqgroup.training.architecture.hexagonalarchitecture.service.repository.ForumDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
class SpringRepositoryImpl implements ForumDao {

    private final ForumRepository repository;

    @Override
    public Forum findForumByName(String forumName){
        return repository.getOne(forumName);
    }

}
