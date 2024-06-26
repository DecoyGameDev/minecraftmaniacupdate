package net.animatrontv.maniacupdate;

import com.mojang.logging.LogUtils;
import net.animatrontv.maniacupdate.block.ModBlocks;
import net.animatrontv.maniacupdate.item.ModCreativeModeTabs;
import net.animatrontv.maniacupdate.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ManiacUpdate.MODID)
public class ManiacUpdate
{
    public static final String MODID = "maniac_update";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ManiacUpdate() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // TAB

        ModCreativeModeTabs.register(modEventBus);

        // REGISTER ITEMS
        ModItems.register(modEventBus);

        // BLOCKS REGISTER
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.DIRTYMETAL);
            event.accept(ModItems.REFINEDMETAL);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
