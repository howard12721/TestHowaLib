package jp.xhw.testhowalib.phase.impl;

import jp.xhw.howalib.phase.PhaseBase;
import jp.xhw.howalib.phase.PhaseEventHandler;
import jp.xhw.testhowalib.phase.PhaseKey;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public class SecondPhase extends PhaseBase<PhaseKey> {

    @Override
    protected void onStart() {

    }

    @Override
    protected void onUpdate() {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Second Phase"));
        }
    }

    @Override
    protected void onEnd() {

    }

    @PhaseEventHandler
    public void on(BlockBreakEvent event) {
        Bukkit.broadcastMessage("Second Phase Block Break");
        changeState(PhaseKey.THIRD);
    }

}
