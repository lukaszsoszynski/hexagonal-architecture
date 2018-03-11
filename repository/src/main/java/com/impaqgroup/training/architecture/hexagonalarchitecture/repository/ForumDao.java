package com.impaqgroup.training.architecture.hexagonalarchitecture.repository;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;

public interface ForumDao {

    Forum findForumByName(String forumName);
}
