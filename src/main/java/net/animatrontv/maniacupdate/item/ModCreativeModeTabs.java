package net.animatrontv.maniacupdate.item;

import net.animatrontv.maniacupdate.ManiacUpdate;
import net.animatrontv.maniacupdate.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ManiacUpdate.MODID);

    public static final RegistryObject<CreativeModeTab> METAL_TAB = CREATIVE_MODE_TABS.register("metal_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DIRTYMETAL.get()))
                    .title(Component.translatable("creativetab.metal_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.DIRTYMETAL.get());
                        pOutput.accept(ModItems.REFINEDMETAL.get());
                        pOutput.accept(ModBlocks.DIRTYMETAL_BLOCK.get());
                        pOutput.accept(ModBlocks.REFINEDMETAL_BLOCK.get());
                        pOutput.accept(ModBlocks.DIRTYMETAL_ORE.get());
                        pOutput.accept(ModBlocks.REFINEDMETAL_ORE.get());
                        pOutput.accept(ModItems.BLAPPLE.get());
                    })
                    .build());

    public static void register(IEventBus eventbus){
        CREATIVE_MODE_TABS.register(eventbus);
    }
}
