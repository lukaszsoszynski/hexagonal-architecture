package com.impaqgroup.training.architecture.hexagonalarchitecture.soapprimaryadapter.converter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.SubForum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class ForumToSubForumConverter implements Converter<Forum, SubForum> {
    @Override
    public SubForum convert(Forum forum) {
        SubForum subForum = new SubForum();
        subForum.setName(forum.getName());
        subForum.setTitle(forum.getTitle());
        return subForum;
    }
}
