package com.brianeno.pocket.read;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ItemTag {
    private final String itemId;
    private final String tag;

    public String getItemId() {
        return itemId;
    }

    public String getTag() {
        return tag;
    }

    public ItemTag(String itemId, String tag) {
        this.itemId = itemId;
        this.tag = tag;
    }
}
