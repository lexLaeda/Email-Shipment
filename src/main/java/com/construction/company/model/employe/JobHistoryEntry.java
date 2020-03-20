package com.construction.company.model.employe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobHistoryEntry {
    private  int duration;
    private  String position;
    private  String company;
}
