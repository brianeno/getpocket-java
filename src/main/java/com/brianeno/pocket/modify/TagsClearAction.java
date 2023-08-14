package com.brianeno.pocket.modify;

public class TagsClearAction extends ModifyAction {

    public TagsClearAction(String itemId) {
        super("tags_clear");
        addAttribute("item_id", itemId);
    }
}
