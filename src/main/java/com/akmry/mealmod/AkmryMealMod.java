package com.akmry.mealmod;

import com.akmry.mealmod.config.CommonConfig;
import com.akmry.mealmod.reference.ModReference;
import com.akmry.mealmod.register.BlockRegister;
import com.akmry.mealmod.register.CreativeModeTabRegister;
import com.akmry.mealmod.register.ItemRegister;
import net.minecraftforge.eventbus.api.IEventBus;
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
    public AkmryMealMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        BlockRegister.BLOCKS.register(modEventBus);
        ItemRegister.ITEMS.register(modEventBus);
        CreativeModeTabRegister.CREATIVE_MODE_TABS.register(modEventBus);

        context.registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
    }
}
