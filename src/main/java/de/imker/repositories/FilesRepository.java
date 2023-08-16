package de.imker.repositories;

import de.imker.models.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<FileUpload, Long> {
}
