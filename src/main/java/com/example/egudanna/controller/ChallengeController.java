package com.example.egudanna.controller;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.dto.challenge.AddChallengeRequest;
import com.example.egudanna.dto.challenge.ChallengeResponse;
import com.example.egudanna.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping("/api/challenges")
    public ResponseEntity<Challenge> addChallenge(@RequestBody AddChallengeRequest request) {
        Challenge savedChallenge = challengeService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedChallenge);
    }

    @GetMapping("/api/challenges")
    public ResponseEntity<List<ChallengeResponse>> findAllChallenges() {
        List<ChallengeResponse> challenges = challengeService.findAll()
                .stream()
                .map(ChallengeResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(challenges);
    }

    @GetMapping("/api/challenges/{id}")
    public ResponseEntity<ChallengeResponse> findChallenge(@PathVariable("id") Long id) {
        Challenge challenge = challengeService.findById(id);

        return ResponseEntity.ok()
                .body(new ChallengeResponse(challenge));
    }
}
