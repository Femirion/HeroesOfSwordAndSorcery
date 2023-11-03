package ru.infernia.core.engine.wrapper;


import lombok.Data;

@Data
public class AnimationInfo extends ImageInfo {
    private int interval;
    private int frameWidth;
    private int frameHeight;
}
