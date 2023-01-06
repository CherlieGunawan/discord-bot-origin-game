package com.cherlie.game.Main;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.eclipse.microprofile.config.ConfigProvider;

import com.cherlie.game.Global.GlobalVariable;
import com.cherlie.game.Service.Discord.BotService;

import io.quarkus.runtime.StartupEvent;
import io.vertx.core.json.JsonArray;

@ApplicationScoped
public class Main {
    @Inject
    BotService botService;

    void onStart(@Observes StartupEvent ev) {
        GlobalVariable.gameChannelNames = new JsonArray(ConfigProvider.getConfig().getValue("game.channel.names", String.class));
        botService.start();
    }
}
