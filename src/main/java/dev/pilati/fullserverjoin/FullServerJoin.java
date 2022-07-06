package dev.pilati.fullserverjoin;


import org.bstats.bukkit.Metrics;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class FullServerJoin extends JavaPlugin implements Listener
{
    public static final int bstatsId = 15685;
    public Metrics bstats;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        bstats = new Metrics(this, bstatsId);
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event){
        if(event.getResult() == PlayerLoginEvent.Result.KICK_FULL){
            if(event.getPlayer().hasPermission("fullserverjoin.bypass")){
                event.allow();
            }
        }
    }
}