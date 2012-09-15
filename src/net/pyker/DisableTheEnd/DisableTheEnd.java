package net.pyker.DisableTheEnd;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DisableTheEnd extends JavaPlugin implements Listener {
	private String warnMsg = ChatColor.RED+"The End is disabled in this server";

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("DisableTheEnd " + getDescription().getVersion() + " enabled");
	}

	public void onDisable() {
		getLogger().info("DisableTheEnd " + getDescription().getVersion() + " disabled");
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.ENDER_PORTAL_FRAME && event.getItem() != null && event.getItem().getType() == Material.EYE_OF_ENDER) {
			event.getPlayer().sendMessage(warnMsg);
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().sendMessage(warnMsg);
	}
}
