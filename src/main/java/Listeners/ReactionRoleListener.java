package Listeners;

import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ReactionRoleListener extends ListenerAdapter {

    @Override
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
        if(event.getMessageId().contains("563780913138368532")) {
                String reactionId = event.getReactionEmote().getName();
                switch (reactionId) {
                    case "weary":
                        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById("563780537878315018")).queue();
                        break;
                }
        }else if (event.getMessageId().contains("550777280155090946")) {
                String reactionId = event.getReactionEmote().getName();
                switch (reactionId) {
                    case "MenheraWave":
                        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById("550773380501209108")).queue();
                        break;
                }
            }
    }

    @Override
    public void onGuildMessageReactionRemove(GuildMessageReactionRemoveEvent event) {
        if(event.getMessageId().contains("563780913138368532")) {
            String reactionId = event.getReactionEmote().getName();
            switch (reactionId) {
                case "weary":
                    event.getGuild().getController().removeRolesFromMember(event.getMember(), event.getGuild().getRoleById("563780537878315018")).queue();
                    break;
            }
        }else if(event.getMessageId().contains("550777280155090946")) {
            String reactionId = event.getReactionEmote().getName();
            switch (reactionId) {
                case "MenheraWave":
                    event.getGuild().getController().removeRolesFromMember(event.getMember(), event.getGuild().getRoleById("550773380501209108")).queue();
                    break;
            }
        }
    }
}
