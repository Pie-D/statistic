package org.pied.stats.api.stats.entity.dto;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatisticReq {

    private String email;

    private String room;

    private Long joinTs;

    private Long leaveTs;

    private Long duration;

    private String sessionId;
}
