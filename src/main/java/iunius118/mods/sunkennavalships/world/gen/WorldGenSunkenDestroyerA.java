package iunius118.mods.sunkennavalships.world.gen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import iunius118.mods.sunkennavalships.SunkenNavalShips;
import iunius118.mods.sunkennavalships.world.gen.structure.StructureSunkenDestroyerA;
import iunius118.mods.sunkennavalships.world.gen.structure.StructureSunkenDestroyerA.Pieces;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenSunkenDestroyerA implements IWorldGenerator
{

    public static final int CHANCE_DENOMINATOR = 12800;
    public static final List<Biome> SPAWN_BIOMES = Arrays.<Biome> asList(Biomes.OCEAN, Biomes.DEEP_OCEAN);

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        EnumFacing facing = EnumFacing.getHorizontal(random.nextInt(4));

        if (!canGenerate(random, chunkX, chunkZ, world))
        {
            return;
        }

        // Check Biome
        if (!canGenerateBiome(facing, chunkX, chunkZ, world))
        {
            return;
        }

        int x = chunkX * 16;
        int z = chunkZ * 16;
        int x1 = x + 8;
        int z1 = z + 8;
        int dx = facing.getDirectionVec().getX() * 16;
        int dz = facing.getDirectionVec().getZ() * 16;

        SunkenNavalShips.logger.info("Generate SunkenDestroyerA between ({}, {}) - ({}, {}).", (x1 + dx * 3), (z1 + dz * 3), (x1 + dx * -4), (z1 + dz * -4));

        // Calculate each section height values
        int depth = random.nextInt(3);
        int heightMidfront = averageHeight(getBottomHeight(world, x1 + dx, z1 + dz) - depth, getBottomHeight(world, x1, z1) - depth, 1);
        int heightBow =  averageHeight(getBottomHeight(world, x1 + dx * 3, z1 + dz * 3) - depth, getBottomHeight(world, x1 + dx * 2, z1 + dz * 2) - depth, heightMidfront);
        int heightMidback =  averageHeight(getBottomHeight(world, x1 + -dx, z1 + -dz) - depth, getBottomHeight(world, x1 + dx * -2, z1 + dz * -2) - depth, heightMidfront);
        int heightStern =  averageHeight(getBottomHeight(world, x1 + dx * -3, z1 + dz * -3) - depth, getBottomHeight(world, x1 + dx * -4, z1 + dz * -4) - depth, heightMidback);

        // Sections
        Section sectionBow;
        Section sectionMidfront;
        Section sectionMidback;
        Section sectionStern;

        int height;
        int capsizing = random.nextInt(3);
        boolean isSeparated = random.nextInt(2) == 0;

        // Calculate each section offsets
        if (isSeparated)
        {
            int separatingPosition = random.nextInt(3);
            boolean isLost = random.nextInt(2) == 0;

            int offsetZ = -random.nextInt(9);
            int offsetX = random.nextInt(5) - 2;
            int twist = random.nextInt(3);

            switch (separatingPosition)
            {
            case 0:
                sectionBow = new Section(!isLost, new BlockPos(offsetX, heightBow, 8), twist);

                height = (heightMidfront + heightMidback + heightStern) / 3;
                sectionMidfront = new Section(true, new BlockPos(0, height, offsetZ), capsizing);
                sectionMidback = new Section(true, new BlockPos(0, height, offsetZ), capsizing);
                sectionStern = new Section(true, new BlockPos(0, height, offsetZ), capsizing);
                break;

            case 1:
                height = (heightBow + heightMidfront) / 2;
                sectionBow = new Section(true, new BlockPos(0, height, 8), capsizing);
                sectionMidfront = new Section(true, new BlockPos(0, height, 8), capsizing);

                height = (heightMidback + heightStern) / 2;
                sectionMidback = new Section(!isLost, new BlockPos(offsetX, height, offsetZ), twist);
                sectionStern = new Section(!isLost, new BlockPos(offsetX, height, offsetZ), twist);
                break;

            default:
                height = (heightBow + heightMidfront + heightMidback) / 3;
                sectionBow = new Section(true, new BlockPos(0, height, 8), capsizing);
                sectionMidfront = new Section(true, new BlockPos(0, height, 8), capsizing);
                sectionMidback = new Section(true, new BlockPos(0, height, 8), capsizing);

                sectionStern = new Section(!isLost, new BlockPos(offsetX, heightStern, offsetZ), twist);
                break;
            }

        }
        else
        {
            height = (heightBow + heightMidfront + heightMidback + heightStern) / 4;
            sectionBow = new Section(true, new BlockPos(0, height, 0), capsizing);
            sectionMidfront = new Section(true, new BlockPos(0, height, 0), capsizing);
            sectionMidback = new Section(true, new BlockPos(0, height, 0), capsizing);
            sectionStern = new Section(true, new BlockPos(0, height, 0), capsizing);
        }

        // Build structure
        StructureSunkenDestroyerA structure = new StructureSunkenDestroyerA();

        if (sectionBow.canGenerate) {
            float integrity = random.nextFloat() * 0.4F + 0.6F;
            structure.pieces.put(Pieces.BOW, structure.structures[sectionBow.capsizing].pieces.get(Pieces.BOW).copy().addOffset(sectionBow.offset).setIntegrity(integrity));

            if (random.nextInt(4) != 0) {
                structure.pieces.put(Pieces.GUN1, structure.structures[sectionBow.capsizing].pieces.get(Pieces.GUN1).copy().addOffset(sectionBow.offset));
            }
        }

        if (sectionMidfront.canGenerate) {
            float integrity = random.nextFloat() * 0.4F + 0.6F;
            structure.pieces.put(Pieces.MIDFRONT, structure.structures[sectionMidfront.capsizing].pieces.get(Pieces.MIDFRONT).copy().addOffset(sectionMidfront.offset).setIntegrity(integrity));

            if (random.nextInt(2) != 0) {
                structure.pieces.put(Pieces.FOREMAST, structure.structures[sectionMidfront.capsizing].pieces.get(Pieces.FOREMAST).copy().addOffset(sectionMidfront.offset));
            }

            if (random.nextInt(5) != 0) {
                structure.pieces.put(Pieces.TORPEDO1, structure.structures[sectionMidfront.capsizing].pieces.get(Pieces.TORPEDO1).copy().addOffset(sectionMidfront.offset));
            }
        }

        if (sectionMidback.canGenerate) {
            float integrity = random.nextFloat() * 0.4F + 0.6F;
            structure.pieces.put(Pieces.MIDBACK, structure.structures[sectionMidback.capsizing].pieces.get(Pieces.MIDBACK).copy().addOffset(sectionMidback.offset).setIntegrity(integrity));

            if (random.nextInt(5) != 0) {
                structure.pieces.put(Pieces.TORPEDO2, structure.structures[sectionMidback.capsizing].pieces.get(Pieces.TORPEDO2).copy().addOffset(sectionMidback.offset));
            }

            if (random.nextInt(2) != 0) {
                structure.pieces.put(Pieces.MAINMAST, structure.structures[sectionMidback.capsizing].pieces.get(Pieces.MAINMAST).copy().addOffset(sectionMidback.offset));
            }
        }

        if (sectionStern.canGenerate) {
            float integrity = random.nextFloat() * 0.4F + 0.6F;
            structure.pieces.put(Pieces.STERN, structure.structures[sectionStern.capsizing].pieces.get(Pieces.STERN).copy().addOffset(sectionStern.offset).setIntegrity(integrity));

            if (random.nextInt(4) != 0) {
                structure.pieces.put(Pieces.GUN2, structure.structures[sectionStern.capsizing].pieces.get(Pieces.GUN2).copy().addOffset(sectionStern.offset));
            }
        }

        // Add blocks to world
        PlacementSettings placement = new PlacementSettings().setReplacedBlock(Blocks.STRUCTURE_VOID);
        structure.addBlocksToWorld(world, new BlockPos(x, 0, z), facing, placement);
    }

    public boolean canGenerate(Random random, int chunkX, int chunkZ, World world)
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

        return random.nextInt(CHANCE_DENOMINATOR) < probability;
    }

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

    private int getBottomHeight(World world, int x, int z)
    {
        int y = world.getHeight(x, z);

        for (; y > 0; y--)
        {
            Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();

            if (!(block instanceof BlockLiquid) && block != Blocks.AIR)
            {
                break;
            }
        }

        return y;
    }

    private int averageHeight(int height1, int height2, int heightDefault)
    {
        if (height1 < 1)
        {
            if (height2 < 1)
            {
                return heightDefault;
            }
            else
            {
                return height2;
            }
        }
        else if (height2 < 1)
        {
            return height1;
        }
        else
        {
            return (height1 + height2) / 2;
        }
    }

    public class Section
    {

        public boolean canGenerate;
        public BlockPos offset;
        public int capsizing;

        public Section(boolean canGenerateIn, BlockPos offsetIn, int capsizingIn)
        {
            canGenerate = canGenerateIn;
            offset = offsetIn;
            capsizing = capsizingIn;
        }

    }

}
