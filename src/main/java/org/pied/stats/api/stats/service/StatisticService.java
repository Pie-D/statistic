package org.pied.stats.api.stats.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pied.stats.api.stats.entity.Statistic;
import org.pied.stats.api.stats.entity.dto.StatisticReq;
import org.pied.stats.api.stats.repository.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticService {
    private final StatisticRepository statisticRepository;

    public List<Statistic> getStatistics() {
        return statisticRepository.findAll();
    }

    public Statistic pushStatistic(StatisticReq req) {
        String room = req.getRoom().split("@")[0];
        Statistic statistic = Statistic.builder()
                .room(room)
                .email(req.getEmail())
                .duration(req.getDuration())
                .joinTs(req.getJoinTs())
                .leaveTs(req.getLeaveTs())
                .sessionId(req.getSessionId())
                .build();
        return statisticRepository.save(statistic);
    }

    public Statistic getStatisticById(UUID id) {
        return statisticRepository.findById(id).orElse(null);
    }
}
