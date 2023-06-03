package jp.xhw.testhowalib;

import jp.xhw.howalib.HowaLib;
import jp.xhw.howalib.phase.PhaseManager;
import jp.xhw.testhowalib.phase.PhaseKey;
import jp.xhw.testhowalib.phase.impl.FirstPhase;
import jp.xhw.testhowalib.phase.impl.SecondPhase;
import jp.xhw.testhowalib.phase.impl.ThirdPhase;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class TestHowaLib extends JavaPlugin {

    @Override
    public void onEnable() {
        HowaLib.onEnable(this);

        PhaseManager<PhaseKey> phaseManager = new PhaseManager<>();

        phaseManager.addPhase(PhaseKey.FIRST, new FirstPhase());
        phaseManager.addPhase(PhaseKey.SECOND, new SecondPhase());
        phaseManager.addPhase(PhaseKey.THIRD, new ThirdPhase());

        new BukkitRunnable() {
            @Override
            public void run() {
                phaseManager.update();
            }
        }.runTaskTimer(this, 0, 1);

    }

    @Override
    public void onDisable() {
        HowaLib.onDisable();
    }
}
