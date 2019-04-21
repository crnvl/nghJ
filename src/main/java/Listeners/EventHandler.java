package Listeners;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class EventHandler extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getMember().getRoles().contains(event.getGuild().getRoleById("569471042121367553"))) {
            int count = 0;
            count = Integer.parseInt(event.getGuild().getTextChannelById("569506971359641630").getTopic());
            event.getGuild().getTextChannelById("569506971359641630").getManager().setTopic(String.valueOf(count + 1)).queue();
        }else if(event.getMember().getRoles().contains(event.getGuild().getRoleById("569471056994369536"))) {
            int count = 0;
            count = Integer.parseInt(event.getGuild().getTextChannelById("569507012736450560").getTopic());
            event.getGuild().getTextChannelById("569507012736450560").getManager().setTopic(String.valueOf(count + 1)).queue();
        }else if(event.getMember().getRoles().contains(event.getGuild().getRoleById("569471608289492994"))) {
            int count = 0;
            count = Integer.parseInt(event.getGuild().getTextChannelById("569507081510584332").getTopic());
            event.getGuild().getTextChannelById("569507081510584332").getManager().setTopic(String.valueOf(count + 1)).queue();
        }
    }
}
