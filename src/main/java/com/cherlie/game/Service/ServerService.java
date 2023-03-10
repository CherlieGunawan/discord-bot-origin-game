package com.cherlie.game.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cherlie.game.Global.GlobalVariable;

import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.channel.GuildChannel;
import discord4j.core.object.entity.channel.MessageChannel;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import reactor.core.publisher.Flux;

@ApplicationScoped
public class ServerService {
    @Inject
    MessageService messageService;

    public boolean initialize(Guild guild, MessageChannel channel) {
        Flux<GuildChannel> channels = guild.getChannels();

        JsonArray gameChannelNames = GlobalVariable.gameChannelNames.copy(); // Init gameChannelNames from static GlobalVariable
        JsonObject jsonChannels = new JsonObject(); // Init variable to store map channels
        channels.subscribe(channelObj -> {
            if(gameChannelNames.contains(channelObj.getName())) {
                messageService.sendMessage(messageService.formatQuote("Found " + channelObj.getName()), channel);
                jsonChannels.put(channelObj.getName(), channelObj.getId().asString()); // Save the ID of the map
                gameChannelNames.remove(channelObj.getName()); // Remove from list for checking
            }
        });

        // If the gameChannelNames is empty, that means the required channels are present
        if(gameChannelNames.isEmpty()) {
            messageService.sendMessage(messageService.formatCodeLine("All channels found, saving..."), channel);

            GlobalVariable.channelsList.put(guild.getId().asString(), jsonChannels); // Save data to channelsList

            messageService.sendMessage(messageService.formatCodeLine("Successfully saved channels"), channel);
        }
        else {
            String channelList = ""; // Init String variable for channels which is not found
            for(int i = 0; i < gameChannelNames.size(); i++) {
                channelList = channelList.concat(gameChannelNames.getString(i));

                if(i < gameChannelNames.size() - 1)
                    channelList = channelList.concat(", ");
            }

            messageService.sendMessage(messageService.formatCodeLine("Required channels not found: ".concat(channelList)), channel);
        }

        String test = guild.getId().asString();
        if(GlobalVariable.channelsList.containsKey(test))
            return true;
        else
            return false;
    }
}
