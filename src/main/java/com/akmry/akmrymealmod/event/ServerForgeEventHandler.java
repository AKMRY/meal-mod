package com.akmry.akmrymealmod.event;

import com.akmry.akmrymealmod.reference.ModReference;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * サーバーのFORGEイベントを処理するためのクラスです。
 */
@Mod.EventBusSubscriber(modid = ModReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class ServerForgeEventHandler {
    /**
     * サーバー起動イベントを処理します.
     *
     * @param event サーバー起動イベント
     */
    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        ModReference.LOGGER.info("HELLO from server starting");
    }
}
