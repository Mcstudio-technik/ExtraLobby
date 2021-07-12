package ik.wuksowik.mop.utils;

import org.bukkit.OfflinePlayer;
import com.google.common.collect.HashBasedTable;
import java.util.UUID;
import com.google.common.collect.Table;

public class CoolDown {
	
    private static Table<UUID, String, Long> timers;
    
    static {
        CoolDown.timers = HashBasedTable.create();
    }
    
    public static void addTimer(final OfflinePlayer p, final String timer, final long time) {
        CoolDown.timers.put(p.getUniqueId(), timer, (System.currentTimeMillis() + time));
    }
    
    public static void stopTimer(final OfflinePlayer p, final String timer) {
        if (!hasTimer(p, timer)) {
            return;
        }
        CoolDown.timers.remove((Object)p.getUniqueId(), (Object)timer);
    }
    
    public static boolean hasTimer(final OfflinePlayer p, final String timer) {
        return CoolDown.timers.contains((Object)p.getUniqueId(), (Object)timer) && (long)CoolDown.timers.get((Object)p.getUniqueId(), (Object)timer) - System.currentTimeMillis() > 0L;
    }
    
    public static long getRemaining(final OfflinePlayer p, final String timer) {
        return hasTimer(p, timer) ? ((long)CoolDown.timers.get((Object)p.getUniqueId(), (Object)timer) - System.currentTimeMillis()) : 0L;
    }
}