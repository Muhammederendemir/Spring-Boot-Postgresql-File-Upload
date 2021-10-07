package com.muhammederendemir.springbootpostgresqlfileupload.service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.muhammederendemir.springbootpostgresqlfileupload.model.FileEntity;
import com.muhammederendemir.springbootpostgresqlfileupload.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;


    public void save(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        fileRepository.save(fileEntity);
    }

    public void update(String id,MultipartFile file) throws IOException {

        FileEntity fileEntity = fileRepository.findById(id).orElseThrow();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());


        fileRepository.save(fileEntity);
    }


    public Optional<FileEntity> getFile(String id) {
        return fileRepository.findById(id);
    }

    public List<FileEntity> getAllFiles() {
        return fileRepository.findAll();
    }
}