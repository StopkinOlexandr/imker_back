package de.imker.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users_on_events")
public class EventFollow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_event_id;


    @Schema(description = "Event's ID", example = "1")
    private Long event_id;

    @Schema(description = "User's ID", example = "1")
    private Long user_id;

    @Schema(description = "Follow status - FOLLOW, UNFOLLOW ", example = "FOLLOW")
    private boolean followedStatus;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Schema(description = "Time of follow state creation", example = "yyyy-MM-dd HH:mm:ss")
    private Date followCreationTime;



}
