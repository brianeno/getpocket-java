package com.brianeno.pocket.modify;

public class FavoriteAction extends ModifyAction {

    public FavoriteAction(String itemId) {
        super("favorite");
        addAttribute("item_id", itemId);
    }
}
