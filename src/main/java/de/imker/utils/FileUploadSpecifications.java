package de.imker.utils;

import de.imker.models.FileUpload;
import org.springframework.data.jpa.domain.Specification;

public class FileUploadSpecifications {

  public static Specification<FileUpload> fileTypeIsNotEmpty() {
    return (root, query, criteriaBuilder) -> criteriaBuilder
        .notEqual(root.get("fileType"), "empty -");
  }
}
