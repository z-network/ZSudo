package gq.devmc.zsudo.commands;

import gq.devmc.zsudo.Main15;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class Util
  implements Listener
{
  public String getName()
  {
    return "Unconfigured Command";
  }
  
  public String getDesc()
  {
    return "Unconfigured Description";
  }
  
  public String getUsage()
  {
    return "Unconfigured Usage";
  }
  
  public boolean isListener()
  {
    return false;
  }
  
  public String getDetailedUsage()
  {
    return "Unconfigured Detailed Usage";
  }
  
  public String getPermission()
  {
    return "zsudo.util.use";
  }
  
  public boolean checkUsage(String[] args)
  {
    return false;
  }
  
  public void printUsage(CommandSender s)
  {
    Main15.error("§7Correct usage: /" + getName() + " " + getUsage(), s);
  }
  
  public void run(CommandSender sender, String[] args)
  {
    Main15.error("§7Command not implemented, but created", sender);
  }
}
