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
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static JDABuilder builder;

    public static void main(String[] Args) {
        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(Config.TOKEN);
        builder.setStatus(OnlineStatus.IDLE);
        builder.setGame(Game.watching("your team"));

        builder.addEventListener(new CommandListener());
        builder.addEventListener(new ReactionRoleListener());
        builder.addEventListener(new TeamListener());
        builder.addEventListener(new EventHandler());
        addCommands();


        try {
            JDA jda = builder.build();
            Timer myTimer1 = new Timer();
            TimerTask task = new TimerTask() {
                int secondsPassed = 0;
                @Override
                public void run() {
                    switch(secondsPassed){
                        case 0:
                            Random ran = new Random();
                            int size = jda.getUsers().size();
                            int y = ran.nextInt(size);
                            jda.getPresence().setGame(Game.watching(jda.getUsers().get(y).getAsTag()));
                            break;
                        case 1:
                            Random ran1 = new Random();
                            int size1 = jda.getUsers().size();
                            int y1 = ran1.nextInt(size1);
                            jda.getPresence().setGame(Game.watching(jda.getUsers().get(y1).getAsTag()));
                            break;
                    }
                }
            };
            myTimer1.schedule(task, 30000, 30000);
        } catch (LoginException e) {
            e.printStackTrace();
        }

    }

    public static void addCommands() {
        CommandHandler.commands.put("teamroles", new refreshTeams());
        CommandHandler.commands.put("stats", new Statistics());
    }

}
