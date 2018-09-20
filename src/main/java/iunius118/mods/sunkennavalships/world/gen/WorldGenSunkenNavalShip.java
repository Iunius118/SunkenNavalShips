package iunius118.mods.sunkennavalships.world.gen;

import java.util.Random;

import org.apache.commons.lang3.tuple.Triple;

import iunius118.mods.sunkennavalships.SunkenNavalShips;
import iunius118.mods.sunkennavalships.world.gen.structure.StructureSunkenShip;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenSunkenNavalShip implements IWorldGenerator
{

    public static final int CHANCE_DENOMINATOR = 3200;

    public static final WorldGenSunkenNavalShip[] WORLD_GEN_SUNKEN_NAVAL_SHIPS = {

            };

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        /* // For debugging
        boolean isDebug = true;

        if (chunkX == 0 && chunkZ == 0)
        {
            boolean isRandomDameged = false;

            if (isRandomDameged)
            {
                WORLD_GEN_SUNKEN_NAVAL_SHIPS[0].generate(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider); // require Biomes.OCEAN world
            } else {
                PlacementSettings placement = new PlacementSettings().setReplacedBlock(Blocks.STRUCTURE_VOID);
                StructureSunkenDestroyerD.structureSunkenDestroyerD0.addBlocksToWorld(world, new BlockPos(chunkX, 6, chunkZ), EnumFacing.SOUTH, placement);
                //StructureSunkenShip.structureTest.addBlocksToWorld(world, new BlockPos(chunkX, 6, chunkZ), EnumFacing.SOUTH, placement);
            }

        }

        if (isDebug) {
            return;
        }
        // */

        if (!canGenerate(chunkX, chunkZ, world))
        {
            return;
        }

        // Generate sunken ship
        int shipType = random.nextInt(WORLD_GEN_SUNKEN_NAVAL_SHIPS.length);
        WORLD_GEN_SUNKEN_NAVAL_SHIPS[shipType].generate(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
    }

    public static Triple<WorldGenSunkenNavalShip, EnumFacing, Random> getWorldGenSunkenNavalShip(int chunkX, int chunkZ, World world)
    {
        int probability = SunkenNavalShips.sunkenShipProbability;
        final int salt = 0x49534E53;

        // Cancel by configuration.
        if (probability == 0)
        {
            return null;
        }

        int dimension = world.provider.getDimension();

        // Only Overworld.
        if ((dimension != 0))
        {
            return null;
        }

        // Only even coordinate chank
        if ((chunkX & 1) == 1 || (chunkZ & 1) == 1)
        {
            return null;
        }

        long seed = (chunkX * 31 + salt) * 31 + chunkZ ^ world.getSeed();
        Random random = new Random(seed);

        // Judge probability.
        int i = random.nextInt(CHANCE_DENOMINATOR);

        if (i >= probability)
        {
            return null;
        }

        // Judge Biome.
        int shipType = random.nextInt(WORLD_GEN_SUNKEN_NAVAL_SHIPS.length);
        WorldGenSunkenNavalShip shipGen = WORLD_GEN_SUNKEN_NAVAL_SHIPS[shipType];
        EnumFacing facing = EnumFacing.byHorizontalIndex(random.nextInt(4));

        if (shipGen.canGenerateBiome(facing, chunkX, chunkZ, world) == false)
        {
            return null;
        }

        return Triple.of(shipGen, facing, random);
    }

    public static boolean canGenerate(int chunkX, int chunkZ, World world)
    {
        return getWorldGenSunkenNavalShip(chunkX, chunkZ, world) != null;
    }

    public boolean canGenerateBiome(EnumFacing facing, int chunkX, int chunkZ, World world)
    {
        return false;
    }

    public int getBottomHeight(World world, int x, int z)
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

    public void addBlocksToWorld(StructureSunkenShip structure, EnumFacing facing, int posX, int posZ, World world)
    {
        if (structure != null)
        {
            PlacementSettings placement = new PlacementSettings().setReplacedBlock(Blocks.STRUCTURE_VOID);
            structure.addBlocksToWorld(world, new BlockPos(posX, 0, posZ), facing, placement);

        }
    }

}
