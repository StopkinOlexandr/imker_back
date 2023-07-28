package de.imker.controllers.api;

import de.imker.dto.NewRequestDto;
import de.imker.dto.RequestDto;
import de.imker.dto.RequestsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tags(value = {
    @Tag(name = "Requests")
})
@RequestMapping("/api/requests")
public interface RequestsApi {


  @Operation(summary = "User Request Creation", description = "Accessible to all users")
  @PostMapping
//  @CrossOrigin(origins = "http://localhost:5173")
  @ResponseStatus(HttpStatus.CREATED)
  RequestDto addRequest(@Parameter(required = true, description = "Request")
                               @RequestBody NewRequestDto newRequest);

  @Operation(summary = "User Request List", description = "Accessible to all users")
  @GetMapping
//  @CrossOrigin(origins = "http://localhost:5173")
  @ResponseStatus(HttpStatus.OK)
  RequestsDto getAllRequests();

}
