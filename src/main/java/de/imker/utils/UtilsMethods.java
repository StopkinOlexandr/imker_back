package de.imker.utils;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class UtilsMethods {
  @NotNull
  public static PageRequest getPageRequest(Integer page, Integer items, String orderBy, Boolean desk) {
    PageRequest pageRequest;
    if (orderBy != null && !orderBy.equals("")) {
      Sort.Direction direction = Sort.Direction.ASC;

      if (desk != null && desk) {
        direction = Sort.Direction.DESC;
      }

      Sort sort = Sort.by(direction, orderBy);
      pageRequest = PageRequest.of(page, items, sort);
    } else {
      pageRequest = PageRequest.of(page, items, Sort.by(Sort.Direction.ASC, "id"));
    }
    return pageRequest;
  }
}
