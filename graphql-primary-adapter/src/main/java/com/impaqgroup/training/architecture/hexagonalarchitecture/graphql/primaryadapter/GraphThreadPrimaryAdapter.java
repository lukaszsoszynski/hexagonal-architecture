package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.GraphThreadService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphCommenceThreadRequest;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphThreadDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Thread;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
class GraphThreadPrimaryAdapter implements GraphThreadService {

    private final ForumService forumService;
    private final ConversionService conversionService;

    @Transactional(readOnly = true)
    public Optional<GraphThreadDto> findThreadById(Long threadId) {
        return forumService
                .findThread(threadId)
                .map(thread -> conversionService.convert(thread, GraphThreadDto.class));
    }

    @Override
    @Transactional//this transactional is not best idea here dut to lack of
    // it should be done on model service layer via XML this case...
    public Supplier<GraphThreadDto> commenceThread(GraphCommenceThreadRequest request) {
        Thread thread = forumService.commenceThread(request.getForumName(),
                request.getThreadName(),
                conversionService.convert(request, Post.class));
        //Workaround: conversion between Thread and GraphThreadDto cannot take place here because transactions
        //was not flush to database and thread object is missing id...
        return () -> conversionService.convert(thread, GraphThreadDto.class);
    }
}
