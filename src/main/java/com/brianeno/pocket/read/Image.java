package com.brianeno.pocket.read;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Image {
    private final String itemId;
    private final String imageId;
    private final String src;
    private final String width;
    private final String height;
    private final String credit;
    private final String caption;

    public Image(String itemId, String imageId, String src, String width, String height, String credit, String caption) {
        this.itemId = itemId;
        this.imageId = imageId;
        this.src = src;
        this.width = width;
        this.height = height;
        this.credit = credit;
        this.caption = caption;
    }
}
