package com.quac.quactils.commands;

import com.quac.quactils.Gui.Screens.MainScreen;
import com.quac.quactils.Main;
import com.quac.quactils.Utils.ChatUtils;
import com.quac.quactils.Utils.Color;
import com.quac.quactils.Utils.TickDelay;
import com.quac.quactils.config.Config;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.util.ArrayList;
import java.util.List;

public class MainCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "quactils";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "quactils";
    }

    @Override
    public List<String> getCommandAliases() {
        List<String> aliases = new ArrayList<>();
        aliases.add("qt");
        return aliases;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if(args.length == 0 || args[0].equalsIgnoreCase("config")) {
            Runnable runnable = () -> Main.setGui(new MainScreen());
            new TickDelay(runnable, 1);
        } else if(args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "version":
                    ChatUtils.addMsg(Color.translate("&aCurrently using " + Main.MODID + " version: " + Main.VERSION));
                    break;
                case "help":
                    ChatUtils.addMsg(Color.translate("&aCurrent arguments: 'help', 'config', 'version'"));
                    break;
                default:
                case "":
                    ChatUtils.addMsg(Color.translate("&cArgument not found! Please use '/qt help' for a list of the arguments"));
                    break;
            }
        }
    }
}
