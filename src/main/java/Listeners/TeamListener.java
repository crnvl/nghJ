package Listeners;

import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Random;

public class TeamListener extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Random role = new Random();
        int get = role.nextInt(3);
        switch (get) {
            case 0:
                //wisdom
                event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("569471042121367553")).queue();
                break;
            case 1:
                event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("569471056994369536")).queue();
                break;
            case 2:
                event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById("569471608289492994")).queue();
                break;
        }
    }
}
