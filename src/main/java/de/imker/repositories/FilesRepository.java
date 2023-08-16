package de.imker.repositories;

import de.imker.models.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilesRepository extends JpaRepository<FileUpload, Long> {
  Optional<FileUpload> getFileById(Long fileId);

}
