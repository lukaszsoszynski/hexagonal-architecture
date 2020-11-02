package com.impaqgroup.training.architecture.hexagonalarchitecture.soapprimaryadapter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.ListSubForumsResponse;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.SoapForumService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.SubForum;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
class ForumSoapPrimaryAdapter implements SoapForumService {

    private final ForumService forumService;
    private final ConversionService conversionService;

    @Override
    public ListSubForumsResponse listSubForums() {
        ListSubForumsResponse listSubForumsResponse = new ListSubForumsResponse();
        listSubForumsResponse
                .getSubForum()
                .addAll(forumService
                        .listAllForums()
                        .stream()
                        .map(forum -> conversionService.convert(forum, SubForum.class))
                        .collect(toList()));
        return listSubForumsResponse;
    }
}
