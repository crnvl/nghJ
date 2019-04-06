package Core;

import Listeners.CommandListener;
import Listeners.ReactionRoleListener;
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
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setGame(Game.watching("lewd anime girls"));

        builder.addEventListener(new CommandListener());
        builder.addEventListener(new ReactionRoleListener());
        addCommands();

        JDA jda = builder.build();

    }

    public static void addCommands() {



    }

}
