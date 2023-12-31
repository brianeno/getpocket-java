package com.brianeno.pocket;

import com.brianeno.pocket.modify.ModifyItemCommand;
import com.brianeno.pocket.modify.ModifyResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.brianeno.pocket.modify.ArchiveAction;
import com.brianeno.pocket.modify.DeleteAction;
import com.brianeno.pocket.modify.FavoriteAction;
import com.brianeno.pocket.modify.TagDeleteAction;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PocketMainModifyTest {

    @Mock
    HttpClient httpClient;

    PocketMain pocketMain;

    @BeforeEach
    void setUp() {
        HttpProvider.change(httpClient);
        pocketMain = new PocketMain(PocketAuthFactory.createForAccessToken("consumer-key", "access-token"));
    }

    @Test
    void shouldExecuteModifyActions() throws IOException {
        // given
        given(httpClient.send(any())).willReturn(new HttpResponse(HTTP_RESPONSE_JSON.getBytes()));
        ModifyItemCommand cmd = new ModifyItemCommand.Builder()
                .action(new ArchiveAction("some-id"))
                .action(new DeleteAction("other-id"))
                .action(new FavoriteAction("some-id"))
                .action(new TagDeleteAction("some-tag"))
                .build();

        // when
        ModifyResult result = pocketMain.modify(cmd);

        // then
        assertThat(result.getActionResults())
                .containsExactly(true, true, false, true);
    }


    @Test
    void shouldThrowPocketException() throws IOException {
        // given
        given(httpClient.send(any())).willThrow(PocketException.class);
        ModifyItemCommand cmd = new ModifyItemCommand.Builder()
                .action(new ArchiveAction("some-id"))
                .action(new DeleteAction("other-id"))
                .action(new FavoriteAction("some-id"))
                .action(new TagDeleteAction("some-tag"))
                .build();

        // when
        Assertions.assertThrows(PocketException.class, () -> pocketMain.modify(cmd));
    }

    private static final String HTTP_RESPONSE_JSON = "{\"action_results\":[true,true,false,true],\"status\":1}";
}