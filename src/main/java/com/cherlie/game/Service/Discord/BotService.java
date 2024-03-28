package com.cherlie.game.Service.Discord;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.config.ConfigProvider;

import com.cherlie.game.Global.GlobalVariable;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.interaction.ButtonInteractionEvent;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

@ApplicationScoped
public class BotService {
    @Inject
    MessageService messageService;

    @Inject
    ButtonService buttonService;

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

            Mono<Void> onButtonClick = gateway.on(ButtonInteractionEvent.class, event -> {
                return buttonService.handleButton(event);
            }).then();

            return saveSelfDiscriminator.and(onDiscordMessage).and(onButtonClick);
        });

        System.out.println(GlobalVariable.selfDiscriminator);

        login.subscribe();
    }
}
