package com.linkout.post.mapper;

import com.linkout.post.dtos.PostRequest;
import com.linkout.post.dtos.PostResponse;
import com.linkout.post.model.Post;
import com.linkout.user.model.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-06T08:46:23-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.12.1 (Amazon.com Inc.)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public List<PostResponse> toResponseList(List<Post> posts) {
        if ( posts == null ) {
            return null;
        }

        List<PostResponse> list = new ArrayList<PostResponse>( posts.size() );
        for ( Post post : posts ) {
            list.add( toResponse( post ) );
        }

        return list;
    }

    @Override
    public PostResponse toResponse(Post post) {
        if ( post == null ) {
            return null;
        }

        Long authorId = null;
        String authorUsername = null;
        Long id = null;
        String content = null;
        String imageUrl = null;
        LocalDateTime createAt = null;
        LocalDateTime updateAt = null;

        authorId = postAuthorId( post );
        authorUsername = postAuthorUsername( post );
        id = post.getId();
        content = post.getContent();
        imageUrl = post.getImageUrl();
        createAt = post.getCreateAt();
        updateAt = post.getUpdateAt();

        PostResponse postResponse = new PostResponse( id, content, imageUrl, authorId, authorUsername, createAt, updateAt );

        return postResponse;
    }

    @Override
    public Post toEntity(PostRequest postRequest) {
        if ( postRequest == null ) {
            return null;
        }

        Post.PostBuilder post = Post.builder();

        post.content( postRequest.content() );

        return post.build();
    }

    private Long postAuthorId(Post post) {
        User author = post.getAuthor();
        if ( author == null ) {
            return null;
        }
        return author.getId();
    }

    private String postAuthorUsername(Post post) {
        User author = post.getAuthor();
        if ( author == null ) {
            return null;
        }
        return author.getUsername();
    }
}
