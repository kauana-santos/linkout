package com.linkout.post.mapper;

import com.linkout.post.dtos.PostRequest;
import com.linkout.post.dtos.PostResponse;
import com.linkout.post.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    List<PostResponse> toResponseList(List<Post> posts);

    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "author.username", target = "authorUsername")
    PostResponse toResponse(Post post);

    @Mapping(target = "author", ignore = true)
    Post toEntity(PostRequest postRequest);
}