package iunius118.mods.sunkennavalships.world.gen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import iunius118.mods.sunkennavalships.SunkenNavalShips;
import net.minecraft.init.Biomes;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
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
        int x1 = posX + 8;
        int z1 = posZ + 8;
        int dx = facing.getDirectionVec().getX() * 16;
        int dz = facing.getDirectionVec().getZ() * 16;

        SunkenNavalShips.logger.info("Generate SunkenDestroyer {} between ({}, {}) - ({}, {})", shipName, (x1 + dx * 3), (z1 + dz * 3), (x1 + dx * -4), (z1 + dz * -4));

        // Calculate each section height values
        int depth = random.nextInt(3);
        int heightMidfront = averageHeight(getBottomHeight(world, x1 + dx, z1 + dz) - depth, getBottomHeight(world, x1, z1) - depth, 1);
        int heightBow =  averageHeight(getBottomHeight(world, x1 + dx * 3, z1 + dz * 3) - depth, getBottomHeight(world, x1 + dx * 2, z1 + dz * 2) - depth, heightMidfront);
        int heightMidback =  averageHeight(getBottomHeight(world, x1 + -dx, z1 + -dz) - depth, getBottomHeight(world, x1 + dx * -2, z1 + dz * -2) - depth, heightMidfront);
        int heightStern =  averageHeight(getBottomHeight(world, x1 + dx * -3, z1 + dz * -3) - depth, getBottomHeight(world, x1 + dx * -4, z1 + dz * -4) - depth, heightMidback);

        int height;
        int capsizing = random.nextInt(3);
        boolean isSeparated = random.nextInt(2) == 0;

        // Calculate each section offsets
        if (isSeparated)
        {
            boolean isLost = random.nextInt(2) == 0;
            int separatingPosition = random.nextInt(4);

            int offsetZ = -random.nextInt(9);
            int offsetX = random.nextInt(5) - 2;
            int twist = random.nextInt(3);

            switch (separatingPosition)
            {
            case 0:
                sections.bow = new Section(!isLost, new BlockPos(offsetX, heightBow, 8), twist);

                height = (heightMidfront + heightMidback + heightStern) / 3;
                sections.midfront = new Section(true, new BlockPos(0, height, offsetZ), capsizing);
                sections.midback = new Section(true, new BlockPos(0, height, offsetZ), capsizing);
                sections.stern = new Section(true, new BlockPos(0, height, offsetZ), capsizing);
                break;

            case 1:
                height = (heightBow + heightMidfront) / 2;
                sections.bow = new Section(true, new BlockPos(0, height, 8), capsizing);
                sections.midfront = new Section(true, new BlockPos(0, height, 8), capsizing);

                height = (heightMidback + heightStern) / 2;
                sections.midback = new Section(!isLost, new BlockPos(offsetX, height, offsetZ), twist);
                sections.stern = new Section(!isLost, new BlockPos(offsetX, height, offsetZ), twist);
                break;

            case 2:
                height = (heightBow + heightMidfront) / 2;
                sections.bow = new Section(!isLost, new BlockPos(0, height, 8), capsizing);
                sections.midfront = new Section(!isLost, new BlockPos(0, height, 8), capsizing);

                height = (heightMidback + heightStern) / 2;
                sections.midback = new Section(true, new BlockPos(offsetX, height, offsetZ), twist);
                sections.stern = new Section(true, new BlockPos(offsetX, height, offsetZ), twist);
                break;

            default:
                height = (heightBow + heightMidfront + heightMidback) / 3;
                sections.bow = new Section(true, new BlockPos(0, height, 8), capsizing);
                sections.midfront = new Section(true, new BlockPos(0, height, 8), capsizing);
                sections.midback = new Section(true, new BlockPos(0, height, 8), capsizing);

                sections.stern = new Section(!isLost, new BlockPos(offsetX, heightStern, offsetZ), twist);
                break;
            }

        }
        else
        {
            height = (heightBow + heightMidfront + heightMidback + heightStern) / 4;
            sections.bow = new Section(true, new BlockPos(0, height, 0), capsizing);
            sections.midfront = new Section(true, new BlockPos(0, height, 0), capsizing);
            sections.midback = new Section(true, new BlockPos(0, height, 0), capsizing);
            sections.stern = new Section(true, new BlockPos(0, height, 0), capsizing);
        }
    }

    @Override
    public boolean canGenerateBiome(EnumFacing facing, int chunkX, int chunkZ, World world)
    {
        int x = chunkX * 16 + 8;
        int z = chunkZ * 16 + 8;

        for (int i = -4; i < 4; i++)
        {
            if (!world.getBiomeProvider().areBiomesViable(x + facing.getDirectionVec().getX() * i * 16, z + facing.getDirectionVec().getZ() * i * 16, 1, SPAWN_BIOMES))
            {
                return false;
            }
        }

        return true;
    }

}
