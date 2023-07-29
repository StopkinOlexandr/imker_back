package de.imker.dto;

import de.imker.models.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Data of the created request")
public class RequestDto {
  @Schema(description = "Request ID in DB", example = "1")
  private Long idRequest;
  @Schema(description = "Time of request creation", example = "yyyy-MM-dd HH:mm:ss")
  private String creationTimeRequest;
  @Schema(description = "User first name", example = "John")
  private String firstNameRequest;
  @Schema(description = "User last name", example = "Smith")
  private String lastNameRequest;
  @Schema(description = "User email", example = "JohnS@gmail.com")
  private String emailRequest;
  @Schema(description = "User phone number", example = "+4 9(123) 456 7890")
  private String phoneRequest;
  @Schema(description = "Request text (max 150 characters)", example = "Lorem ipsum, dolor...")
  private String textOfRequest;

  public static RequestDto from(Request request){
    return RequestDto.builder()
        .idRequest(request.getIdRequest())
        .creationTimeRequest(dateToString(request.getCreationTimeRequest()))
        .firstNameRequest(request.getFirstNameRequest())
        .lastNameRequest(request.getLastNameRequest())
        .emailRequest(request.getEmailRequest())
        .phoneRequest(request.getPhoneRequest())
        .textOfRequest(request.getTextOfRequest())
        .build();
  }

  public static List<RequestDto> from(List<Request> requests){
    return requests.stream()
        .map(RequestDto::from)
        .collect(Collectors.toList());
  }

  public static String dateToString(Date date){
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return dateFormat.format(date);
  }
}
