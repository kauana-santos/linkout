package com.linkout.post.controller;

import com.linkout.post.dtos.PostRequest;
import com.linkout.post.dtos.PostResponse;
import com.linkout.post.dtos.PostUpdateRequest;
import com.linkout.post.service.PostService;
import com.linkout.user.dtos.UserResponse;
import com.linkout.user.dtos.UserUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    @Operation(summary = "criar novo post")
    public List<PostResponse> findAll(){
       return postService.findAll();
    }

    @PostMapping
    public ResponseEntity<PostResponse> create(@Valid @RequestBody PostRequest postRequest){
        return ResponseEntity.status(201).body(postService.create(postRequest));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um post")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um post")
    public PostResponse update(@PathVariable Long id, @Valid @RequestBody PostUpdateRequest postUpdateRequest){
        return postService.update(id, postUpdateRequest);
    }
}
