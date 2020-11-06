package ru.infernia.figure;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Straight {
    private Point start;
    private Point end;
}
