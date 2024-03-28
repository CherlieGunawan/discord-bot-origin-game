package com.cherlie.game.Main;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import org.eclipse.microprofile.config.ConfigProvider;

import com.cherlie.game.Global.GlobalVariable;
import com.cherlie.game.Service.Discord.BotService;
import com.cherlie.game.Service.Entity.SkillService;

import io.quarkus.runtime.StartupEvent;
import io.vertx.core.json.JsonArray;

@ApplicationScoped
public class Main {
    @Inject
    SkillService skillService;

    @Inject
    BotService botService;

    void onStart(@Observes StartupEvent ev) {
        // Initialize variables from DB
        skillService.initialize();
        GlobalVariable.gameChannelNames = new JsonArray(ConfigProvider.getConfig().getValue("game.channel.names", String.class));
        
        botService.start();
    }
}
