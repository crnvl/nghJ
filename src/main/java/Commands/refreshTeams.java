package Commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.IOException;
import java.util.Random;

public class refreshTeams implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getMember().getUser().getId().contains("265849018662387712")) {
            event.getTextChannel().sendMessage("Refreshing Teamroles...").queue();
            event.getTextChannel().sendMessage("Removing Roles...").queue();
            for (int i = 0; i < event.getGuild().getMembers().size(); i++) {
                event.getGuild().getController().removeRolesFromMember(event.getGuild().getMembers().get(i), event.getGuild().getRoleById("569471042121367553"), event.getGuild().getRoleById("569471056994369536"), event.getGuild().getRoleById("569471608289492994")).queue();
            }
            event.getTextChannel().sendMessage("Completed!").queue();
            event.getTextChannel().sendMessage("Adding new teamroles...").queue();
            for (int i = 0; i < event.getGuild().getMembers().size(); i++) {
                Random role = new Random();
                int get = role.nextInt(3);
                switch (get) {
                    case 0:
                        event.getGuild().getController().addSingleRoleToMember(event.getGuild().getMembers().get(i), event.getGuild().getRoleById("569471042121367553")).queue();
                        break;
                    case 1:
                        event.getGuild().getController().addSingleRoleToMember(event.getGuild().getMembers().get(i), event.getGuild().getRoleById("569471056994369536")).queue();
                        break;
                    case 2:
                        event.getGuild().getController().addSingleRoleToMember(event.getGuild().getMembers().get(i), event.getGuild().getRoleById("569471608289492994")).queue();
                        break;
                }
            }
                event.getTextChannel().sendMessage("Completed!").queue();
                event.getTextChannel().sendMessage("Refresh done.").queue();
        }else {
            event.getTextChannel().sendMessage(":x: Sorry, you're not allowed to use this command!").queue();
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
