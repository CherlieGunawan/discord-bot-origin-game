package com.cherlie.game.Service.Discord;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import discord4j.core.object.command.Interaction;
import reactor.core.publisher.Mono;

@ApplicationScoped
public class ButtonService {
    @Inject
    MessageService messageService;

    public Mono<Object> handleButton(Interaction interaction) {
        // messageService.sendMessage(interaction.toString(), interaction.getChannel().block());
        // messageService.sendMessage(interaction.getMember().get().toString(), interaction.getChannel().block());
        messageService.sendMessage(interaction.getMember().get().getNickname().get(), interaction.getChannel().block());
        // messageService.sendMessage(interaction.getMessage().get().getContent(), interaction.getChannel().block());
        return Mono.empty();
    }
}
