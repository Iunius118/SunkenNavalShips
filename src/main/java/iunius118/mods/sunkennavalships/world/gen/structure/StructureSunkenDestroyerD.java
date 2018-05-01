package iunius118.mods.sunkennavalships.world.gen.structure;

import iunius118.mods.sunkennavalships.SunkenNavalShips;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;

public class StructureSunkenDestroyerD extends StructureSunkenShip
{

    public enum Pieces
    {
        BOW, GUN1,
        MIDFRONT, GUN2, FOREMAST,
        MIDBACK, TORPEDO1, TORPEDO2, MAINMAST,
        STERN, GUN3;
    }

    public enum IDs
    {

        UK_DD_J_0_BOW_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_0_bow")),
        UK_DD_J_0_MIDFRONT_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_0_midfront")),
        UK_DD_J_0_MIDBACK_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_0_midback")),
        UK_DD_J_0_STERN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_0_stern")),
        UK_DD_J_0_FOREMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_0_foremast")),
        UK_DD_J_0_MAINMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_0_mainmast")),
        UK_DD_J_0_GUN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_0_gun")),
        UK_DD_J_0_TORPEDO_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_0_torpedo")),

        UK_DD_J_1_BOW_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_1_bow")),
        UK_DD_J_1_MIDFRONT_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_1_midfront")),
        UK_DD_J_1_MIDBACK_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_1_midback")),
        UK_DD_J_1_STERN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_1_stern")),
        UK_DD_J_1_FOREMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_1_foremast")),
        UK_DD_J_1_MAINMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_1_mainmast")),
        UK_DD_J_1_GUN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_1_gun")),
        UK_DD_J_1_TORPEDO_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_1_torpedo")),

        UK_DD_J_2_TORPEDO_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "uk_dd_j/uk_dd_j_2_torpedo"));

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

    public static final StructureSunkenDestroyerD structureSunkenDestroyerD0;
    static
    {
        structureSunkenDestroyerD0 = new StructureSunkenDestroyerD();

        structureSunkenDestroyerD0
                .addPiece(Pieces.BOW, IDs.UK_DD_J_0_BOW_ID.getId(), null, null, new BlockPos(3, 0, 32), 1.0F)
                .addPiece(Pieces.GUN1, IDs.UK_DD_J_0_GUN_ID.getId(), null, null, new BlockPos(5, 10, 36), 1.0F)

                .addPiece(Pieces.MIDFRONT, IDs.UK_DD_J_0_MIDFRONT_ID.getId(), null, null, new BlockPos(2, 0, 0), 1.0F)
                .addPiece(Pieces.GUN2, IDs.UK_DD_J_0_GUN_ID.getId(), null, null, new BlockPos(5, 14, 28), 1.0F)
                .addPiece(Pieces.FOREMAST, IDs.UK_DD_J_0_FOREMAST_ID.getId(), null, null, new BlockPos(2, 8, 8), 1.0F)

                .addPiece(Pieces.MIDBACK, IDs.UK_DD_J_0_MIDBACK_ID.getId(), null, null, new BlockPos(2, 0, -32), 1.0F)
                .addPiece(Pieces.TORPEDO1, IDs.UK_DD_J_0_TORPEDO_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(9, 7, -5), 1.0F)
                .addPiece(Pieces.TORPEDO2, IDs.UK_DD_J_0_TORPEDO_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(9, 7, -19), 1.0F)
                .addPiece(Pieces.MAINMAST, IDs.UK_DD_J_0_MAINMAST_ID.getId(), null, null, new BlockPos(6, 7, -30), 1.0F)

                .addPiece(Pieces.STERN, IDs.UK_DD_J_0_STERN_ID.getId(), null, null, new BlockPos(2, 0, -55), 1.0F)
                .addPiece(Pieces.GUN3, IDs.UK_DD_J_0_GUN_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(9, 10, -36), 1.0F);
    }

    public static final StructureSunkenDestroyerD structureSunkenDestroyerD1;
    static
    {
        structureSunkenDestroyerD1 = new StructureSunkenDestroyerD();

        structureSunkenDestroyerD1
                .addPiece(Pieces.BOW, IDs.UK_DD_J_1_BOW_ID.getId(), null, null, new BlockPos(2, 1, 32), 1.0F)
                .addPiece(Pieces.GUN1, IDs.UK_DD_J_1_GUN_ID.getId(), null, null, new BlockPos(12, 3, 36), 1.0F)

                .addPiece(Pieces.MIDFRONT, IDs.UK_DD_J_1_MIDFRONT_ID.getId(), null, null, new BlockPos(2, 0, 0), 1.0F)
                .addPiece(Pieces.GUN2, IDs.UK_DD_J_1_GUN_ID.getId(), null, null, new BlockPos(16, 3, 28), 1.0F)
                .addPiece(Pieces.FOREMAST, IDs.UK_DD_J_1_FOREMAST_ID.getId(), null, null, new BlockPos(10, 0, 8), 1.0F)

                .addPiece(Pieces.MIDBACK, IDs.UK_DD_J_1_MIDBACK_ID.getId(), null, null, new BlockPos(2, 0, -32), 1.0F)
                .addPiece(Pieces.TORPEDO1, IDs.UK_DD_J_2_TORPEDO_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(9, 3, -5), 1.0F)
                .addPiece(Pieces.TORPEDO2, IDs.UK_DD_J_2_TORPEDO_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(9, 3, -19), 1.0F)
                .addPiece(Pieces.MAINMAST, IDs.UK_DD_J_1_MAINMAST_ID.getId(), null, null, new BlockPos(9, 4, -30), 1.0F)

                .addPiece(Pieces.STERN, IDs.UK_DD_J_1_STERN_ID.getId(), null, null, new BlockPos(2, 0, -55), 1.0F)
                .addPiece(Pieces.GUN3, IDs.UK_DD_J_1_GUN_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(12, 3, -36), 1.0F);

    }

    public static final StructureSunkenDestroyerD structureSunkenDestroyerD2;
    static
    {
        structureSunkenDestroyerD2 = new StructureSunkenDestroyerD();

        structureSunkenDestroyerD2
                .addPiece(Pieces.BOW, IDs.UK_DD_J_1_BOW_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 1, 32), 1.0F)
                .addPiece(Pieces.GUN1, IDs.UK_DD_J_1_GUN_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(2, 3, 36), 1.0F)

                .addPiece(Pieces.MIDFRONT, IDs.UK_DD_J_1_MIDFRONT_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 0, 0), 1.0F)
                .addPiece(Pieces.GUN2, IDs.UK_DD_J_1_GUN_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(-2, 3, 28), 1.0F)
                .addPiece(Pieces.FOREMAST, IDs.UK_DD_J_1_FOREMAST_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(4, 0, 8), 1.0F)

                .addPiece(Pieces.MIDBACK, IDs.UK_DD_J_1_MIDBACK_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 0, -32), 1.0F)
                .addPiece(Pieces.TORPEDO1, IDs.UK_DD_J_1_TORPEDO_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(5, 3, -5), 1.0F)
                .addPiece(Pieces.TORPEDO2, IDs.UK_DD_J_1_TORPEDO_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(5, 3, -19), 1.0F)
                .addPiece(Pieces.MAINMAST, IDs.UK_DD_J_1_MAINMAST_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(5, 4, -30), 1.0F)

                .addPiece(Pieces.STERN, IDs.UK_DD_J_1_STERN_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 0, -55), 1.0F)
                .addPiece(Pieces.GUN3, IDs.UK_DD_J_1_GUN_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(2, 3, -36), 1.0F);
    }

    public static final StructureSunkenDestroyerD[] structures = {structureSunkenDestroyerD0, structureSunkenDestroyerD1, structureSunkenDestroyerD2};

    public StructureSunkenDestroyerD()
    {

    }

}
