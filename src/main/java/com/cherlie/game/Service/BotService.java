package com.cherlie.game.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.ConfigProvider;

import com.cherlie.game.Global.GlobalVariable;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

@ApplicationScoped
public class BotService {
    @Inject
    MessageService messageService;

    public void start() {
        DiscordClient client = DiscordClient.create(ConfigProvider.getConfig().getValue("discord.bot.token", String.class));
        Mono<Void> login = client.withGateway((GatewayDiscordClient gateway) -> {
            Mono<Void> saveSelfDiscriminator = gateway.on(ReadyEvent.class, event ->
                Mono.fromRunnable(() -> {
                    GlobalVariable.selfDiscriminator = event.getSelf().getDiscriminator();
                })
            ).then();

            Mono<Void> onDiscordMessage = gateway.on(MessageCreateEvent.class, event -> {
                return messageService.handleMessage(event.getMessage());
            }).then();

            return saveSelfDiscriminator.and(onDiscordMessage);
        });

        System.out.println(GlobalVariable.selfDiscriminator);

        login.subscribe();
    }
}
