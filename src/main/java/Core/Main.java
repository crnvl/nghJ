package Core;

import Commands.Statistics;
import Commands.refreshTeams;
import Listeners.CommandListener;
import Listeners.EventHandler;
import Listeners.ReactionRoleListener;
import Listeners.TeamListener;
import Utility.CommandHandler;
import Utility.Config;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class Main {

    public static JDABuilder builder;

    public static void main(String[] Args) throws LoginException {
        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(Config.TOKEN);
        builder.setStatus(OnlineStatus.IDLE);
        builder.setGame(Game.watching("your team"));

        builder.addEventListener(new CommandListener());
        builder.addEventListener(new ReactionRoleListener());
        builder.addEventListener(new TeamListener());
        builder.addEventListener(new EventHandler());
        addCommands();

        JDA jda = builder.build();

    }

    public static void addCommands() {
        CommandHandler.commands.put("teamroles", new refreshTeams());
        CommandHandler.commands.put("stats", new Statistics());
    }

}
