package com.ohgiraffers.familyblog.controller;

import com.ohgiraffers.familyblog.dto.AlbumDTO;
import com.ohgiraffers.familyblog.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/albums")
    public String listAlbums(Model model) {
        model.addAttribute("albums", albumService.getAllAlbums());
        return "album/albumList";
    }

    @GetMapping("/albums/{id}")
    public String viewAlbum(@PathVariable Long id, Model model) {
        model.addAttribute("album", albumService.getAlbumById(id));
        return "album/albumDetail";
    }
}

// AlbumController는 앨범 페이지와 관련된 요청을 처리한다. 앨범 목록 앨범 상세 페이지 등을 담당한다.