package gq.devmc.zsudo.commands;

import net.md_5.bungee.api.ChatColor;
import gq.devmc.zsudo.Main15;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ZSudo
  extends Util
{
  public String getName()
  {
    return "zsudo";
  }
  
  public String getDesc()
  {
    return "§7run a command as someone else";
  }
  
  public String getUsage()
  {
    return "<player> <input>";
  }
  
  public boolean isListener()
  {
    return false;
  }
  
  public String getDetailedUsage()
  {
    return "Usage: /zsudo <player> <input>";
  }
  
  public String getPermission()
  {
    return "znetwork.zsudo";
  }
  
  public boolean checkUsage(String[] args)
  {
    if (args.length >= 2) {
      return true;
    }
    return false;
  }
  
  public void run(CommandSender sender, String[] args)
  {
    String user = args[0];
    String input = "";
    int i = 1;
    while (i < args.length)
    {
      input = input + args[i] + " ";
      i++;
    }
    input = input.trim();
    boolean command = input.startsWith("/");
    CommandSender u = null;
    if (user.equalsIgnoreCase("c")) {
      u = Bukkit.getConsoleSender();
    } else {
      u = Bukkit.getPlayer(user);
    }
    if (u == null)
    {
      Main15.error("§7I can't find §c" + user + " §7anywhere on the server!", sender);
      return;
    }
    if (command)
    {
      input = input.substring(1);
      Bukkit.dispatchCommand(u, input);
      sender.sendMessage(Main15.prefix + "§7Sucessfully ran command §8[§7" + input + "§8]§7 as §8[§7" + ChatColor.GRAY + u.getName() + ChatColor.GRAY + "§8]");
    }
    else
    {
      if (!(u instanceof Player))
      {
        Main15.error("§7What you're sudoing cannot chat!", sender);
        return;
      }
      Player p = (Player)u;
      p.chat(input);
      sender.sendMessage(Main15.prefix + "§7Sucessfully said §8[§7" + input + "§8]§7 as §8[§7" + u.getName() + "§8]");
    }
  }
}
