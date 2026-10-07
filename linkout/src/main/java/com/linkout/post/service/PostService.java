package com.linkout.post.service;

import com.linkout.post.dtos.PostRequest;
import com.linkout.post.dtos.PostResponse;
import com.linkout.post.dtos.PostUpdateRequest;
import com.linkout.post.mapper.PostMapper;
import com.linkout.post.model.Post;
import com.linkout.post.repository.PostsRepository;
import com.linkout.user.model.User;
import com.linkout.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostsRepository postsRepository;
    private final PostMapper postMapper;
    private final UserRepository userRepository;

    public PostService(PostsRepository postsRepository, PostMapper postMapper, UserRepository userRepository) {
        this.postsRepository = postsRepository;
        this.postMapper = postMapper;
        this.userRepository = userRepository;
    }

    public List<PostResponse> findAll(){
        return postMapper.toResponseList(postsRepository.findAll());
    }

    public PostResponse create(PostRequest postRequest){
        Post post = postMapper.toEntity(postRequest);

        User user = userRepository.findById(postRequest.authorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        post.setAuthor(user);
        Post postSalvo = postsRepository.save(post);

        System.out.println("CREATE AT: " + postSalvo.getCreateAt());

        return postMapper.toResponse(postSalvo);
    }

    public PostResponse update(Long id, PostUpdateRequest updateRequest){
        Post post = postsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        post.setContent(updateRequest.content());

        return postMapper.toResponse(postsRepository.save(post));
    }

    public void delete(Long id){
        Post post = postsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        postsRepository.delete(post);
    }

}


