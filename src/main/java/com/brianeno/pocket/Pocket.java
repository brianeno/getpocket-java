package com.brianeno.pocket;

import com.brianeno.pocket.add.AddItemCmd;
import com.brianeno.pocket.add.AddItemResult;
import com.brianeno.pocket.modify.ModifyItemCmd;
import com.brianeno.pocket.modify.ModifyResult;
import com.brianeno.pocket.read.GetItemsCmd;
import com.brianeno.pocket.read.GetItemsResult;

import java.io.IOException;

public class Pocket {

    private final PocketAuth pocketAuth;

    public Pocket(PocketAuth pocketAuth) {
        this.pocketAuth = pocketAuth;
    }

    public GetItemsResult getItems(GetItemsCmd cmd) throws IOException {
        ((AuthorizedCmd) cmd).setAuth(pocketAuth);
        HttpRequest getRequest = HttpRequest.postJson("https://getpocket.com/v3/get", cmd);
        return HttpProvider.get().send(getRequest).asObject(GetItemsResult.class);
    }

    public AddItemResult addItem(AddItemCmd cmd) throws IOException {
        ((AuthorizedCmd) cmd).setAuth(pocketAuth);
        HttpRequest addRequest = HttpRequest.postJson("https://getpocket.com/v3/add", cmd);
        return HttpProvider.get().send(addRequest).asObject(AddItemResult.class);
    }

    public ModifyResult modify(ModifyItemCmd cmd) throws IOException {
        ((AuthorizedCmd) cmd).setAuth(pocketAuth);
        HttpRequest modifyRequest = HttpRequest.postJson("https://getpocket.com/v3/send", cmd);
        return HttpProvider.get().send(modifyRequest).asObject(ModifyResult.class);
    }
}
