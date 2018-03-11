package com.impaqgroup.training.architecture.hexagonalarchitecture.service.repository;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;

public interface ForumDao {

    Forum findForumByName(String forumName);
}
