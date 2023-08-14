package com.brianeno.pocket.modify;

public class UnfavoriteAction extends ModifyAction {

    public UnfavoriteAction(String itemId) {
        super("unfavorite");
        addAttribute("item_id", itemId);
    }
}
