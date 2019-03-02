package gq.devmc.zsudo;

import net.md_5.bungee.api.ChatColor;
import gq.devmc.zsudo.commands.Util;
import gq.devmc.zsudo.commands.ZSudo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main15
  extends JavaPlugin
{
  public static final Util[] commands = { new ZSudo() };
  public static final String prefix = ChatColor.GRAY + "§8[" + ChatColor.DARK_GREEN + "§6§lZSudo" + ChatColor.GRAY + "§8] ";
  
  public void onEnable() {}
  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    execute(sender, label, args);
    return true;
  }
  
  public boolean execute(CommandSender sender, String label, String[] args)
  {
    boolean handled = false;
    for (Util c : commands) {
      if (label.equalsIgnoreCase(c.getName()))
      {
        if (!sender.hasPermission(c.getPermission()))
        {
          error("§7You do not have permission to use the command " + c.getName(), sender);
          return true;
        }
        if (!c.checkUsage(args))
        {
          error("§cInvalid usage for command: " + c.getName(), sender);
          c.printUsage(sender);
          return true;
        }
        c.run(sender, args);
        handled = true;
      }
    }
    if (!handled) {
      error("§cUnknown Subcommand", sender);
    }
    return true;
  }
  
  public static void error(String s, CommandSender cs)
  {
    cs.sendMessage(prefix + ChatColor.DARK_RED + "Error: " + ChatColor.RED + s);
  }
}
