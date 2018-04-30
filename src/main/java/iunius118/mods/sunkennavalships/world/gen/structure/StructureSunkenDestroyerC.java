package iunius118.mods.sunkennavalships.world.gen.structure;

import iunius118.mods.sunkennavalships.SunkenNavalShips;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.PlacementSettings;

public class StructureSunkenDestroyerC extends StructureSunkenShip
{

    public enum Pieces
    {
        BOW, GUN1, GUN2,
        MIDFRONT, MAINMAST, TORPEDO1,
        MIDBACK, TORPEDO2, GUN3, GUN4,
        STERN, GUN5;
    }

    public enum IDs
    {

        US_DD_FLETCHER_0_BOW_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_0_bow")),
        US_DD_FLETCHER_0_MIDFRONT_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_0_midfront")),
        US_DD_FLETCHER_0_MIDBACK_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_0_midback")),
        US_DD_FLETCHER_0_STERN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_0_stern")),
        US_DD_FLETCHER_0_MAINMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_0_mainmast")),
        US_DD_FLETCHER_0_GUN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_0_gun")),
        US_DD_FLETCHER_0_TORPEDO_A_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_0_torpedo_a")),
        US_DD_FLETCHER_0_TORPEDO_B_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_0_torpedo_b")),

        US_DD_FLETCHER_1_BOW_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_1_bow")),
        US_DD_FLETCHER_1_MIDFRONT_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_1_midfront")),
        US_DD_FLETCHER_1_MIDBACK_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_1_midback")),
        US_DD_FLETCHER_1_STERN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_1_stern")),
        US_DD_FLETCHER_1_MAINMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_1_mainmast")),
        US_DD_FLETCHER_1_GUN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_1_gun")),
        US_DD_FLETCHER_1_TORPEDO_A_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_1_torpedo_a")),
        US_DD_FLETCHER_1_TORPEDO_B_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_1_torpedo_b")),


        US_DD_FLETCHER_2_MIDFRONT_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_2_midfront")),
        US_DD_FLETCHER_2_MIDBACK_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "us_dd_fletcher/us_dd_fletcher_2_midback"));

        private ResourceLocation id;

        private IDs(ResourceLocation idIn)
        {
            id = idIn;
        }

        public ResourceLocation getId()
        {
            return id;
        }

    }

    public static final StructureSunkenDestroyerC structureSunkenDestroyerC0;
    static
    {
        structureSunkenDestroyerC0 = new StructureSunkenDestroyerC();

        structureSunkenDestroyerC0
                .addPiece(Pieces.BOW, IDs.US_DD_FLETCHER_0_BOW_ID.getId(), null, null, new BlockPos(3, 0, 32), 1.0F)
                .addPiece(Pieces.GUN1, IDs.US_DD_FLETCHER_0_GUN_ID.getId(), null, null, new BlockPos(6, 9, 38), 1.0F)
                .addPiece(Pieces.GUN2, IDs.US_DD_FLETCHER_0_GUN_ID.getId(), null, null, new BlockPos(6, 12, 31), 1.0F)

                .addPiece(Pieces.MIDFRONT, IDs.US_DD_FLETCHER_0_MIDFRONT_ID.getId(), null, null, new BlockPos(2, 0, 0), 1.0F)
                .addPiece(Pieces.MAINMAST, IDs.US_DD_FLETCHER_0_MAINMAST_ID.getId(), null, null, new BlockPos(4, 8, 14), 1.0F)
                .addPiece(Pieces.TORPEDO1, IDs.US_DD_FLETCHER_0_TORPEDO_A_ID.getId(), null, null, new BlockPos(5, 11, 1), 1.0F)

                .addPiece(Pieces.MIDBACK, IDs.US_DD_FLETCHER_0_MIDBACK_ID.getId(), null, null, new BlockPos(2, 0, -32), 1.0F)
                .addPiece(Pieces.TORPEDO2, IDs.US_DD_FLETCHER_0_TORPEDO_B_ID.getId(), null, null, new BlockPos(5, 10, -13), 1.0F)
                .addPiece(Pieces.GUN3, IDs.US_DD_FLETCHER_0_GUN_ID.getId(), null, null, new BlockPos(6, 10, -21), 1.0F)
                .addPiece(Pieces.GUN4, IDs.US_DD_FLETCHER_0_GUN_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(6, 10, -29), 1.0F)

                .addPiece(Pieces.STERN, IDs.US_DD_FLETCHER_0_STERN_ID.getId(), null, null, new BlockPos(3, 0, -56), 1.0F)
                .addPiece(Pieces.GUN5, IDs.US_DD_FLETCHER_0_GUN_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(6, 7, -37), 1.0F);
    }

    public static final StructureSunkenDestroyerC structureSunkenDestroyerC1;
    static
    {
        structureSunkenDestroyerC1 = new StructureSunkenDestroyerC();

        structureSunkenDestroyerC1
                .addPiece(Pieces.BOW, IDs.US_DD_FLETCHER_1_BOW_ID.getId(), null, null, new BlockPos(2, 1, 32), 1.0F)
                .addPiece(Pieces.GUN1, IDs.US_DD_FLETCHER_1_GUN_ID.getId(), null, null, new BlockPos(11, 4, 38), 1.0F)
                .addPiece(Pieces.GUN2, IDs.US_DD_FLETCHER_1_GUN_ID.getId(), null, null, new BlockPos(14, 4, 31), 1.0F)

                .addPiece(Pieces.MIDFRONT, IDs.US_DD_FLETCHER_1_MIDFRONT_ID.getId(), null, null, new BlockPos(2, 0, 0), 1.0F)
                .addPiece(Pieces.MAINMAST, IDs.US_DD_FLETCHER_1_MAINMAST_ID.getId(), null, null, new BlockPos(10, 2, 14), 1.0F)
                .addPiece(Pieces.TORPEDO1, IDs.US_DD_FLETCHER_1_TORPEDO_A_ID.getId(), null, null, new BlockPos(13, 3, 1), 1.0F)

                .addPiece(Pieces.MIDBACK, IDs.US_DD_FLETCHER_1_MIDBACK_ID.getId(), null, null, new BlockPos(2, 0, -32), 1.0F)
                .addPiece(Pieces.TORPEDO2, IDs.US_DD_FLETCHER_1_TORPEDO_B_ID.getId(), null, null, new BlockPos(12, 3, -13), 1.0F)
                .addPiece(Pieces.GUN3, IDs.US_DD_FLETCHER_1_GUN_ID.getId(), null, null, new BlockPos(12, 4, -21), 1.0F)
                .addPiece(Pieces.GUN4, IDs.US_DD_FLETCHER_1_GUN_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(12, 4, -29), 1.0F)

                .addPiece(Pieces.STERN, IDs.US_DD_FLETCHER_1_STERN_ID.getId(), null, null, new BlockPos(2, 1, -56), 1.0F)
                .addPiece(Pieces.GUN5, IDs.US_DD_FLETCHER_1_GUN_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(9, 4, -37), 1.0F);
    }

    public static final StructureSunkenDestroyerC structureSunkenDestroyerC2;
    static
    {
        structureSunkenDestroyerC2 = new StructureSunkenDestroyerC();

        structureSunkenDestroyerC2
                .addPiece(Pieces.BOW, IDs.US_DD_FLETCHER_1_BOW_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 1, 32), 1.0F)
                .addPiece(Pieces.GUN1, IDs.US_DD_FLETCHER_1_GUN_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(3, 4, 38), 1.0F)
                .addPiece(Pieces.GUN2, IDs.US_DD_FLETCHER_1_GUN_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(0, 4, 31), 1.0F)

                .addPiece(Pieces.MIDFRONT, IDs.US_DD_FLETCHER_2_MIDFRONT_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 0, 0), 1.0F)
                .addPiece(Pieces.MAINMAST, IDs.US_DD_FLETCHER_1_MAINMAST_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(4, 2, 14), 1.0F)
                .addPiece(Pieces.TORPEDO1, IDs.US_DD_FLETCHER_1_TORPEDO_A_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(1, 3, 1), 1.0F)

                .addPiece(Pieces.MIDBACK, IDs.US_DD_FLETCHER_2_MIDBACK_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 0, -32), 1.0F)
                .addPiece(Pieces.TORPEDO2, IDs.US_DD_FLETCHER_1_TORPEDO_B_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(2, 3, -13), 1.0F)
                .addPiece(Pieces.GUN3, IDs.US_DD_FLETCHER_1_GUN_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(2, 4, -21), 1.0F)
                .addPiece(Pieces.GUN4, IDs.US_DD_FLETCHER_1_GUN_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(2, 4, -29), 1.0F)

                .addPiece(Pieces.STERN, IDs.US_DD_FLETCHER_1_STERN_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 1, -56), 1.0F)
                .addPiece(Pieces.GUN5, IDs.US_DD_FLETCHER_1_GUN_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(5, 4, -37), 1.0F);
    }

    public static final StructureSunkenDestroyerC[] structures = {structureSunkenDestroyerC0, structureSunkenDestroyerC1, structureSunkenDestroyerC2};

    public StructureSunkenDestroyerC()
    {

    }

    public void addBlocksToWorld(World world, BlockPos pos, EnumFacing facing, PlacementSettings placement)
    {
        for (Piece piece : pieces.values())
        {
            piece.addBlocksToWorld(world, pos, facing, placement);
        }
    }

}
