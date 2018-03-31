package com.impaqgroup.training.architecture.hexagonalarchitecture.model.repository;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.stereotype.InputPort;

@InputPort
public interface ForumDao {

    Forum findForumByName(String forumName);
}
