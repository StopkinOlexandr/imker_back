package de.imker.utils;

import de.imker.models.FileUpload;
import org.springframework.data.jpa.domain.Specification;

public class FileUploadSpecifications {

  public static Specification<FileUpload> fileFilter(String filter) {
    return switch (filter) {
      case "ALL" -> ((root, query, criteriaBuilder) -> criteriaBuilder.notEqual(root.get("fileType"), "empty -"));
      case "POST" -> (root, query, criteriaBuilder) ->
          criteriaBuilder.equal(root.get("category"), FileUpload.Category.POST);
      case "EVENT" -> (root, query, criteriaBuilder) ->
          criteriaBuilder.equal(root.get("category"), FileUpload.Category.EVENT);
      case "AVATAR" -> (root, query, criteriaBuilder) ->
          criteriaBuilder.equal(root.get("category"), FileUpload.Category.AVATAR);
      case "GALLERY" -> (root, query, criteriaBuilder) ->
          criteriaBuilder.equal(root.get("category"), FileUpload.Category.GALLERY);
      case "SLIDER" -> (root, query, criteriaBuilder) ->
          criteriaBuilder.equal(root.get("category"), FileUpload.Category.SLIDER);
      case "NONE" -> (root, query, criteriaBuilder) -> criteriaBuilder.and(
          criteriaBuilder.equal(root.get("category"), FileUpload.Category.NONE),
          criteriaBuilder.notEqual(root.get("fileType"), "empty -")
      );
      default -> ((root, query, criteriaBuilder) -> criteriaBuilder.notEqual(root.get("fileType"), "empty -"));
    };
  }
}
