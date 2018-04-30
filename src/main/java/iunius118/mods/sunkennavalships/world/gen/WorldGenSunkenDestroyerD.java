package iunius118.mods.sunkennavalships.world.gen;

import java.util.Random;

import iunius118.mods.sunkennavalships.world.gen.structure.StructureSunkenDestroyerD;
import iunius118.mods.sunkennavalships.world.gen.structure.StructureSunkenShip;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldGenSunkenDestroyerD extends WorldGenSunkenDestroyer
{

    public static final String SHIP_NAME = "type D";

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        EnumFacing facing = EnumFacing.getHorizontal(random.nextInt(4));

        // Check Biome
        if (!canGenerateBiome(facing, chunkX, chunkZ, world))
        {
            return;
        }

        // Initialize sections
        Sections sections = new Sections();
        int x = chunkX * 16;
        int z = chunkZ * 16;
        initSections(SHIP_NAME, sections, random, facing, x, z, world);

        // Build structure
        StructureSunkenShip structure = new StructureSunkenShip();
        StructureSunkenShip[] structures = StructureSunkenDestroyerD.structures;

        if (sections.bow.canGenerate) {
            int sectionCapsizing = sections.bow.capsizing;
            BlockPos sectionOffset = sections.bow.offset;
            float integrity = random.nextFloat() * 0.4F + 0.6F;

            structure.addPieceFromStructures(StructureSunkenDestroyerD.Pieces.BOW, structures, sectionCapsizing, sectionOffset, integrity);

            if (random.nextInt(4) != 0) {
                structure.addPieceFromStructures(StructureSunkenDestroyerD.Pieces.GUN1, structures, sectionCapsizing, sectionOffset);
            }
        }

        if (sections.midfront.canGenerate) {
            int sectionCapsizing = sections.midfront.capsizing;
            BlockPos sectionOffset = sections.midfront.offset;
            float integrity = random.nextFloat() * 0.4F + 0.6F;

            structure.addPieceFromStructures(StructureSunkenDestroyerD.Pieces.MIDFRONT, structures, sectionCapsizing, sectionOffset, integrity);

            if (random.nextInt(4) != 0) {
                structure.addPieceFromStructures(StructureSunkenDestroyerD.Pieces.GUN2, structures, sectionCapsizing, sectionOffset);
            }

            if (random.nextInt(2) != 0) {
                structure.addPieceFromStructures(StructureSunkenDestroyerD.Pieces.FOREMAST, structures, sectionCapsizing, sectionOffset);
            }
        }

        if (sections.midback.canGenerate) {
            int sectionCapsizing = sections.midback.capsizing;
            BlockPos sectionOffset = sections.midback.offset;
            float integrity = random.nextFloat() * 0.4F + 0.6F;

            structure.addPieceFromStructures(StructureSunkenDestroyerD.Pieces.MIDBACK, structures, sectionCapsizing, sectionOffset, integrity);

            if (random.nextInt(5) != 0) {
                structure.addPieceFromStructures(StructureSunkenDestroyerD.Pieces.TORPEDO1, structures, sectionCapsizing, sectionOffset);
            }

            if (random.nextInt(5) != 0) {
                structure.addPieceFromStructures(StructureSunkenDestroyerD.Pieces.TORPEDO2, structures, sectionCapsizing, sectionOffset);
            }

            if (random.nextInt(2) != 0) {
                structure.addPieceFromStructures(StructureSunkenDestroyerD.Pieces.MAINMAST, structures, sectionCapsizing, sectionOffset);
            }
        }

        if (sections.stern.canGenerate) {
            int sectionCapsizing = sections.stern.capsizing;
            BlockPos sectionOffset = sections.stern.offset;
            float integrity = random.nextFloat() * 0.4F + 0.6F;

            structure.addPieceFromStructures(StructureSunkenDestroyerD.Pieces.STERN, structures, sectionCapsizing, sectionOffset, integrity);

            if (random.nextInt(4) != 0) {
                structure.addPieceFromStructures(StructureSunkenDestroyerD.Pieces.GUN3, structures, sectionCapsizing, sectionOffset);
            }
        }

        addBlocksToWorld(structure, facing, x, z, world);
    }

}