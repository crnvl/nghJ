package Commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class Statistics implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(
                new EmbedBuilder()
                        .setTitle("Team Statistics")
                        .setColor(Color.PINK)
                        .addField("Team Wisdom", event.getGuild().getTextChannelById("569506971359641630").getTopic() + " Messages", true)
                        .addField("Team Courage", event.getGuild().getTextChannelById("569507012736450560").getTopic() + " Messages", true)
                        .addField("Team Strength", event.getGuild().getTextChannelById("569507081510584332").getTopic() + " Messages", true)
                        .build()
        ).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
