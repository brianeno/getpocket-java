package com.brianeno.pocket.read;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Video {
    private final String itemId;
    private final String videoId;
    private final String src;
    private final String width;
    private final String height;
    private final String type;
    private final String vid;

    public Video(String itemId, String videoId, String src, String width, String height, String type, String vid) {
        this.itemId = itemId;
        this.videoId = videoId;
        this.src = src;
        this.width = width;
        this.height = height;
        this.type = type;
        this.vid = vid;
    }
}
