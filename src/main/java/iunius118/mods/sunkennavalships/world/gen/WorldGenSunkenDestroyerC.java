package iunius118.mods.sunkennavalships.world.gen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import iunius118.mods.sunkennavalships.SunkenNavalShips;
import iunius118.mods.sunkennavalships.world.gen.structure.StructureSunkenDestroyerC;
import iunius118.mods.sunkennavalships.world.gen.structure.StructureSunkenDestroyerC.Pieces;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;

public class WorldGenSunkenDestroyerC extends WorldGenSunkenNavalShip
{

    public static final List<Biome> SPAWN_BIOMES = Arrays.<Biome> asList(Biomes.OCEAN, Biomes.DEEP_OCEAN);

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        EnumFacing facing = EnumFacing.getHorizontal(random.nextInt(4));

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

        SunkenNavalShips.logger.info("Generate SunkenDestroyer type C between ({}, {}) - ({}, {})", (x1 + dx * 3), (z1 + dz * 3), (x1 + dx * -4), (z1 + dz * -4));

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
        StructureSunkenDestroyerC structure = new StructureSunkenDestroyerC();

        if (sectionBow.canGenerate) {
            int sectionCapsizing = sectionBow.capsizing;
            BlockPos sectionOffset = sectionBow.offset;
            float integrity = random.nextFloat() * 0.4F + 0.6F;

            structure.pieces.put(Pieces.BOW, structure.structures[sectionCapsizing].pieces.get(Pieces.BOW).copy().addOffset(sectionOffset).setIntegrity(integrity));

            if (random.nextInt(4) != 0) {
                structure.pieces.put(Pieces.GUN1, structure.structures[sectionCapsizing].pieces.get(Pieces.GUN1).copy().addOffset(sectionOffset));
            }

            if (random.nextInt(4) != 0) {
                structure.pieces.put(Pieces.GUN2, structure.structures[sectionCapsizing].pieces.get(Pieces.GUN2).copy().addOffset(sectionOffset));
            }
        }

        if (sectionMidfront.canGenerate) {
            int sectionCapsizing = sectionMidfront.capsizing;
            BlockPos sectionOffset = sectionMidfront.offset;
            float integrity = random.nextFloat() * 0.4F + 0.6F;

            structure.pieces.put(Pieces.MIDFRONT, structure.structures[sectionCapsizing].pieces.get(Pieces.MIDFRONT).copy().addOffset(sectionOffset).setIntegrity(integrity));

            if (random.nextInt(2) != 0) {
                structure.pieces.put(Pieces.MAINMAST, structure.structures[sectionCapsizing].pieces.get(Pieces.MAINMAST).copy().addOffset(sectionOffset));
            }

            if (random.nextInt(5) != 0) {
                structure.pieces.put(Pieces.TORPEDO1, structure.structures[sectionCapsizing].pieces.get(Pieces.TORPEDO1).copy().addOffset(sectionOffset));
            }
        }

        if (sectionMidback.canGenerate) {
            int sectionCapsizing = sectionMidback.capsizing;
            BlockPos sectionOffset = sectionMidback.offset;
            float integrity = random.nextFloat() * 0.4F + 0.6F;

            structure.pieces.put(Pieces.MIDBACK, structure.structures[sectionCapsizing].pieces.get(Pieces.MIDBACK).copy().addOffset(sectionOffset).setIntegrity(integrity));

            if (random.nextInt(5) != 0) {
                structure.pieces.put(Pieces.TORPEDO2, structure.structures[sectionCapsizing].pieces.get(Pieces.TORPEDO2).copy().addOffset(sectionOffset));
            }

            if (random.nextInt(4) != 0) {
                structure.pieces.put(Pieces.GUN3, structure.structures[sectionCapsizing].pieces.get(Pieces.GUN3).copy().addOffset(sectionOffset));
            }

            if (random.nextInt(4) != 0) {
                structure.pieces.put(Pieces.GUN4, structure.structures[sectionCapsizing].pieces.get(Pieces.GUN4).copy().addOffset(sectionOffset));
            }
        }

        if (sectionStern.canGenerate) {
            int sectionCapsizing = sectionStern.capsizing;
            BlockPos sectionOffset = sectionStern.offset;
            float integrity = random.nextFloat() * 0.4F + 0.6F;

            structure.pieces.put(Pieces.STERN, structure.structures[sectionCapsizing].pieces.get(Pieces.STERN).copy().addOffset(sectionOffset).setIntegrity(integrity));

            if (random.nextInt(4) != 0) {
                structure.pieces.put(Pieces.GUN5, structure.structures[sectionCapsizing].pieces.get(Pieces.GUN5).copy().addOffset(sectionOffset));
            }

        }

        // Add blocks to world
        PlacementSettings placement = new PlacementSettings().setReplacedBlock(Blocks.STRUCTURE_VOID);
        structure.addBlocksToWorld(world, new BlockPos(x, 0, z), facing, placement);
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
