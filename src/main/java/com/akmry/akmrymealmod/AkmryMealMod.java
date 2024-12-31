package com.akmry.akmrymealmod;

import com.akmry.akmrymealmod.config.CommonConfig;
import com.akmry.akmrymealmod.reference.ModReference;
import com.akmry.akmrymealmod.register.BlockRegister;
import com.akmry.akmrymealmod.register.CreativeModeTabRegister;
import com.akmry.akmrymealmod.register.ItemRegister;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * MODのエントリポイントとなるクラスです。
 */
@Mod(ModReference.MOD_ID)
public class AkmryMealMod {
    /**
     * コンストラクタ
     *
     * @param context モッドローディングコンテキスト
     */
    public AkmryMealMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockRegister.BLOCKS.register(modEventBus);
        ItemRegister.ITEMS.register(modEventBus);
        CreativeModeTabRegister.CREATIVE_MODE_TABS.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
    }
}
