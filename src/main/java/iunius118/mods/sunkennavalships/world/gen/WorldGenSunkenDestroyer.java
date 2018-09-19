package iunius118.mods.sunkennavalships.world.gen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.init.Biomes;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class WorldGenSunkenDestroyer extends WorldGenSunkenNavalShip
{

    public static final List<Biome> SPAWN_BIOMES = Arrays.<Biome> asList(Biomes.OCEAN, Biomes.DEEP_OCEAN);

    public class Sections
    {
        public Section bow;
        public Section midfront;
        public Section midback;
        public Section stern;
    }

    public void initSections(String shipName, Sections sections, Random random, EnumFacing facing, int posX, int posZ, World world)
    {

    }

    @Override
    public boolean canGenerateBiome(EnumFacing facing, int chunkX, int chunkZ, World world)
    {
        int x = chunkX * 16 + 8;
        int z = chunkZ * 16 + 8;
        int vx = 0;
        int vz = 1;

        if (facing == EnumFacing.EAST || facing == EnumFacing.WEST)
        {
            vx = 1;
            vz = 0;
        }

        for (int i = -1; i <= 1; i++)
        {
            int x1 = x + vx * i * 32;
            int z1 = z + vz * i * 32;

            if (!world.getBiomeProvider().areBiomesViable(x1, z1, 1, SPAWN_BIOMES)
                    || !world.getBiomeProvider().areBiomesViable(x1 + 16, z1, 1, SPAWN_BIOMES)
                    || !world.getBiomeProvider().areBiomesViable(x1, z1 + 16, 1, SPAWN_BIOMES)
                    || !world.getBiomeProvider().areBiomesViable(x1 + 16, z1 + 16, 1, SPAWN_BIOMES))
            {
                return false;
            }
        }

        return true;
    }

}
