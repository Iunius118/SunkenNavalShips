package iunius118.mods.sunkennavalships.worldgen;

import java.util.Random;

import iunius118.mods.sunkennavalships.SunkenNavalShips;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenSunkenDestroyerA implements IWorldGenerator
{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {

    }

    public boolean canGenerate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        int probability = SunkenNavalShips.sunkenShipProbability;

        if (probability == 0)
        {
            return false;
        }

        int dimension = world.provider.getDimension();
        // Exclude Nether and End.
        if ((dimension == 1 || dimension == -1))
        {
            return false;
        }
        
        world.getHeight(x, z)

        return false;
    }

}
