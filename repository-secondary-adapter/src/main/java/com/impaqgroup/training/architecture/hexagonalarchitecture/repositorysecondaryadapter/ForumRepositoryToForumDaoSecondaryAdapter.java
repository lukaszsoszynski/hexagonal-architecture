package com.impaqgroup.training.architecture.hexagonalarchitecture.repositorysecondaryadapter;

import org.springframework.stereotype.Repository;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.repository.ForumDao;
import com.impaqgroup.training.architecture.hexagonalarchitecture.repository.jpa.ForumRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Repository
class ForumRepositoryToForumDaoSecondaryAdapter implements ForumDao {

    private final ForumRepository repository;

    @Override
    public Forum findForumByName(String forumName){
        return repository.getOne(forumName);
    }

    @Override
    public List<Forum> findAll() {
        return repository.findAll();
    }

}
