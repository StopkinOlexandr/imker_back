package de.imker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Follow event")
public class EventFollowDto {

  @Schema(description = "Event's ID", example = "1")
  private Long idEvent;

  @Schema(description = "User's ID", example = "1")
  private Long idUser;

  @Schema(description = "Follow status - FOLLOW, UNFOLLOW ", example = "FOLLOW")
  private boolean followedStatus;


//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @Schema(description = "Time of follow state creation", example = "yyyy-MM-dd HH:mm:ss")
//    private String followCreationTime;


//    public static EventFollowDto from(EventFollow eventFollow) {
//        return EventFollowDto.builder()
//                .idEvent(eventFollow.getEvent_id())
//                .idUser(eventFollow.getUser_id())
////                .followCreationTime(dateToString(eventFollow.getFollowCreationTime()))
//                .followedStatus(eventFollow.isFollowedStatus())
//
//
//                //.followedStatus()
//                //.followCreationTime(eventFollow.ge)
//                .build();
//
//    }
//
//    public static List<EventFollowDto> from(List<EventFollow> eventsFollow) {
//        return eventsFollow.stream()
//                .map(EventFollowDto::from)
//                .collect(Collectors.toList());
//    }

  public static String dateToString(Date date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return dateFormat.format(date);
  }


}
