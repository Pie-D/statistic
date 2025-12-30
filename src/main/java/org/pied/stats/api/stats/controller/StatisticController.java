package org.pied.stats.api.stats.controller;

import lombok.RequiredArgsConstructor;
import org.pied.stats.api.stats.entity.Statistic;
import org.pied.stats.api.stats.entity.dto.StatisticReq;
import org.pied.stats.api.stats.service.StatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statistic")
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticService statisticService;


    @PostMapping
    public ResponseEntity<Statistic> addStatistic(@RequestBody StatisticReq statistic) {
        return ResponseEntity.ok(statisticService.pushStatistic(statistic));
    }

    @GetMapping
    public ResponseEntity<List<Statistic>> getStatistics() {
        return ResponseEntity.ok(statisticService.getStatistics());
    }
}
