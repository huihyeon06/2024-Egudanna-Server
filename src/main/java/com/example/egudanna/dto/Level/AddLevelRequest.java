package com.example.egudanna.dto.Level;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddLevelRequest {

    private Long id;
    private String level;
}
