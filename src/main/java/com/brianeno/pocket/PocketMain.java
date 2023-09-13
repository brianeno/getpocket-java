package com.brianeno.pocket;

import com.brianeno.pocket.add.AddItemCommand;
import com.brianeno.pocket.add.AddItemResult;
import com.brianeno.pocket.modify.ModifyItemCommand;
import com.brianeno.pocket.modify.ModifyResult;
import com.brianeno.pocket.read.GetItemsCommand;
import com.brianeno.pocket.read.GetItemsResult;

import java.io.IOException;

public class PocketMain {

    private final PocketAuth pocketAuth;

    public PocketMain(PocketAuth pocketAuth) {
        this.pocketAuth = pocketAuth;
    }

    public GetItemsResult getItems(GetItemsCommand cmd) throws IOException {
        ((AuthorizedCommand) cmd).setAuth(pocketAuth);
        HttpRequest getRequest = HttpRequest.postJson("https://getpocket.com/v3/get", cmd);
        return HttpProvider.get().send(getRequest).asObject(GetItemsResult.class);
    }

    public AddItemResult addItem(AddItemCommand cmd) throws IOException {
        ((AuthorizedCommand) cmd).setAuth(pocketAuth);
        HttpRequest addRequest = HttpRequest.postJson("https://getpocket.com/v3/add", cmd);
        return HttpProvider.get().send(addRequest).asObject(AddItemResult.class);
    }

    public ModifyResult modify(ModifyItemCommand cmd) throws IOException {
        ((AuthorizedCommand) cmd).setAuth(pocketAuth);
        HttpRequest modifyRequest = HttpRequest.postJson("https://getpocket.com/v3/send", cmd);
        return HttpProvider.get().send(modifyRequest).asObject(ModifyResult.class);
    }
}
