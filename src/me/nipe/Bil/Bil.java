package me.nipe.Bil;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

/**
 * Created by Mads og Thomas on 17/06/2016.
 */
public class Bil extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Bil plugin has been enabled");

    }

    @Override
    public void onDisable() {
        getLogger().info("Bil plugin has been disabled");

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String comandLabel, String [] args) {
        if (cmd.getName().equalsIgnoreCase("bil") && sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;

            // Hvor er jeg:
            Location eyelocation = player.getEyeLocation();

            // Hvilken vej vender jeg:
            Vector vec = player.getLocation().getDirection();

            // Find placeringen foran mig:
            Location frontlocation = eyelocation.add(vec);

            // Spawn et eller andet foran mig:
            player.getWorld().spawnEntity(frontlocation, EntityType.MINECART);

            return true;
        }
        return false;
    }
}
