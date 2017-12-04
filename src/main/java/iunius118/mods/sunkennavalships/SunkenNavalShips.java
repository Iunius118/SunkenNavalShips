package iunius118.mods.sunkennavalships;

import iunius118.mods.sunkennavalships.worldgen.WorldGenSunkenDestroyerA;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = SunkenNavalShips.MOD_ID,
        name = SunkenNavalShips.MOD_NAME,
        version = SunkenNavalShips.MOD_VERSION,
        dependencies = SunkenNavalShips.MOD_DEPENDENCIES,
        useMetadata = true
        )
@EventBusSubscriber
public class SunkenNavalShips
{

    public static final String MOD_ID = "sunkennavalships";
    public static final String MOD_NAME = "SunkenNavalShips";
    public static final String MOD_VERSION = "${version}";
    public static final String MOD_DEPENDENCIES = "required-after:forge@[1.12-14.21.1.2387,)";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerWorldGenerator(new WorldGenSunkenDestroyerA(), 5);
    }

}
