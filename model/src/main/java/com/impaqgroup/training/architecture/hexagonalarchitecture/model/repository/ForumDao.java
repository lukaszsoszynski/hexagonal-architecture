package com.impaqgroup.training.architecture.hexagonalarchitecture.model.repository;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.stereotype.InputPort;

import java.util.List;
import java.util.Optional;

@InputPort
public interface ForumDao {

    Forum findForumByName(String forumName);

    List<Forum> findAll();

    Optional<Forum> findForumByThreadId(Long threadId);
}
