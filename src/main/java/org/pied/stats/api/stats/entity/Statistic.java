package org.pied.stats.api.stats.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "statistic")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Statistic {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "room", nullable = false)
    private String room;

    @Column(name = "join_ts", nullable = false)
    private Long joinTs;

    @Column(name = "leave_ts", nullable = false)
    private Long leaveTs;

    @Column(name = "duration", nullable = false)
    private Long duration;

    @Column(name = "session_id", nullable = false)
    private String sessionId;
}
