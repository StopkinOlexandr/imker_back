package de.imker.repositories;

import de.imker.models.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface FilesRepository extends JpaRepository<FileUpload, Long>, JpaSpecificationExecutor<FileUpload> {
  Optional<FileUpload> getFileById(Long fileId);

}
