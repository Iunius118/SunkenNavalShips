package iunius118.mods.sunkennavalships;

import java.util.Map;

import org.apache.logging.log4j.Logger;

import iunius118.mods.sunkennavalships.world.gen.WorldGenSunkenNavalShip;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.config.GuiConfigEntries.NumberSliderEntry;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkCheckHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod
(
        modid = SunkenNavalShips.MOD_ID,
        name = SunkenNavalShips.MOD_NAME,
        version = SunkenNavalShips.MOD_VERSION,
        dependencies = SunkenNavalShips.MOD_DEPENDENCIES,
        guiFactory = "iunius118.mods.sunkennavalships.client.gui.ConfigGuiFactory",
        useMetadata = true
        )
@EventBusSubscriber
public class SunkenNavalShips
{

    public static final String MOD_ID = "sunkennavalships";
    public static final String MOD_NAME = "SunkenNavalShips";
    public static final String MOD_VERSION = "${version}";
    public static final String MOD_DEPENDENCIES = "required-after:forge@[1.12-14.21.1.2387,)";

    public static Logger logger;
    public static int sunkenShipProbability = 32;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        Config.loadConfig(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerWorldGenerator(new WorldGenSunkenNavalShip(), 5);
        MinecraftForge.EVENT_BUS.register(this);    // For subscribing ConfigChangedEvent
    }

    @NetworkCheckHandler
    public boolean netCheckHandler(Map<String, String> mods, Side side)
    {
        return true;
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(MOD_ID))
        {
            Config.config.save();
            sunkenShipProbability = Config.propSunkenShipProbability.getInt();
        }
    }

    public static class Config
    {

        public static Configuration config;

        public static Property propSunkenShipProbability;

        public static void loadConfig(FMLPreInitializationEvent event)
        {
            config = new Configuration( event.getSuggestedConfigurationFile() );
            config.load();

            propSunkenShipProbability = Config.config.get(Configuration.CATEGORY_GENERAL, "sunkenShipProbability", sunkenShipProbability,
                    "The Probability of generating sunken ship. 0 - 100. Set to 0 for stopping sunken ship generator.", 0, 100);

            if (event.getSide().isClient())
            {
                propSunkenShipProbability.setConfigEntryClass(NumberSliderEntry.class);
            }

            sunkenShipProbability = propSunkenShipProbability.getInt();

            config.save();
        }

    }

}
