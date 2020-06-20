package org.screamingsandals.bedwars.commands;

import org.bukkit.command.CommandSender;
import org.screamingsandals.bedwars.Main;

import java.util.List;

import static misat11.lib.lang.I18n.i18n;

public class ListCommand extends BaseCommand {

    public ListCommand() {
        super("list", null, true);
    }

    @Override
    public boolean execute(CommandSender sender, List<String> args) {
        sender.sendMessage(i18n("list_header"));
        Main.sendGameListInfo(sender);
        return true;
    }

    @Override
    public void completeTab(List<String> completion, CommandSender sender, List<String> args) {
    }

}
