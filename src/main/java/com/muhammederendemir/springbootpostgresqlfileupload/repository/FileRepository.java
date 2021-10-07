package com.muhammederendemir.springbootpostgresqlfileupload.repository;

import com.muhammederendemir.springbootpostgresqlfileupload.model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends RevisionRepository<FileEntity, String, Integer>,JpaRepository<FileEntity, String> {
}