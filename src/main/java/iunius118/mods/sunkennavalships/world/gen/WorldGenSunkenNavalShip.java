package iunius118.mods.sunkennavalships.world.gen;

import java.util.Random;

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

    public static final int CHANCE_DENOMINATOR = 12800;

    public static final WorldGenSunkenNavalShip[] WORLD_GEN_SUNKEN_NAVAL_SHIPS = {
            new WorldGenSunkenDestroyerA(),
            new WorldGenSunkenDestroyerB(),
            new WorldGenSunkenDestroyerC(),
            new WorldGenSunkenDestroyerD()
            };

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        /* // For debugging
        boolean isDebug = false;

        if (chunkX == 0 && chunkZ == 0)
        {
            boolean isRandomDameged = false;

            if (isRandomDameged)
            {
                WORLD_GEN_SUNKEN_NAVAL_SHIPS[0].generate(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider); // require Biomes.OCEAN world
            } else {
                PlacementSettings placement = new PlacementSettings().setReplacedBlock(Blocks.STRUCTURE_VOID);
                StructureSunkenDestroyerD.structureSunkenDestroyerD2.addBlocksToWorld(world, new BlockPos(chunkX, 6, chunkZ), EnumFacing.SOUTH, placement);
                //StructureSunkenShip.structureTest.addBlocksToWorld(world, new BlockPos(chunkX, 6, chunkZ), EnumFacing.SOUTH, placement);
            }

        }

        if (isDebug) {
            return;
        }
        // */

        if (!canGenerate(random, chunkX, chunkZ, world))
        {
            return;
        }

        // Generate sunken ship
        int shipType = random.nextInt(WORLD_GEN_SUNKEN_NAVAL_SHIPS.length);
        WORLD_GEN_SUNKEN_NAVAL_SHIPS[shipType].generate(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
    }

    public boolean canGenerate(Random random, int chunkX, int chunkZ, World world)
    {
        int probability = SunkenNavalShips.sunkenShipProbability;

        // Cancel by configuration.
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

        // Judge!
        int i = random.nextInt(CHANCE_DENOMINATOR);
        boolean result = i < probability;

        return result;
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

    public int averageHeight(int height1, int height2, int heightDefault)
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

    public void addBlocksToWorld(StructureSunkenShip structure, EnumFacing facing, int posX, int posZ, World world)
    {
        if (structure != null)
        {
            PlacementSettings placement = new PlacementSettings().setReplacedBlock(Blocks.STRUCTURE_VOID);
            structure.addBlocksToWorld(world, new BlockPos(posX, 0, posZ), facing, placement);

        }
    }

}
