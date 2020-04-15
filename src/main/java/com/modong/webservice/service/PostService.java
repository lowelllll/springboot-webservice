package com.modong.webservice.service;

import com.modong.webservice.domain.PostRepository;
import com.modong.webservice.dto.PostResponseDTO;
import com.modong.webservice.dto.PostRequestDTO;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostService {
    private PostRepository postRepository;

    @Transactional
    public Long save(PostRequestDTO request) {
        return postRepository.save(request.toPost()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostResponseDTO> findAllDesc() {
        return postRepository.findAllDesc()
                .map(PostResponseDTO::new) // post -> new PostResponseDTO(post)
                .collect(Collectors.toList());
    }
}
