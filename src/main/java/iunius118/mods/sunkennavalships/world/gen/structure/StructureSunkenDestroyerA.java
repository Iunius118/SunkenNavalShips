package iunius118.mods.sunkennavalships.world.gen.structure;

import iunius118.mods.sunkennavalships.SunkenNavalShips;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;

public class StructureSunkenDestroyerA extends StructureSunkenShip
{

    public enum Pieces
    {
        BOW, GUN1,
        MIDFRONT, FOREMAST, TORPEDO1,
        MIDBACK, TORPEDO2, MAINMAST,
        STERN, GUN2;
    }

    public enum IDs
    {

        JP_DD_A_0_BOW_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_bow")),
        JP_DD_A_0_MIDFRONT_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_midfront")),
        JP_DD_A_0_MIDBACK_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_midback")),
        JP_DD_A_0_STERN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_stern")),
        JP_DD_A_0_FOREMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_foremast")),
        JP_DD_A_0_MAINMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_mainmast")),
        JP_DD_A_0_GUN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_gun")),
        JP_DD_A_0_TORPEDO_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_torpedo")),

        JP_DD_A_1_BOW_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_1_bow")),
        JP_DD_A_1_MIDFRONT_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_1_midfront")),
        JP_DD_A_1_MIDBACK_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_1_midback")),
        JP_DD_A_1_STERN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_1_stern")),
        JP_DD_A_1_FOREMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_1_foremast")),
        JP_DD_A_1_MAINMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_1_mainmast")),
        JP_DD_A_1_GUN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_1_gun")),
        JP_DD_A_1_TORPEDO_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_1_torpedo")),

        JP_DD_A_2_MIDBACK_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_2_midback")),
        JP_DD_A_2_GUN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_2_gun"));

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

    public static final StructureSunkenDestroyerA structureSunkenDestroyerA0;
    static
    {
        structureSunkenDestroyerA0 = new StructureSunkenDestroyerA();

        structureSunkenDestroyerA0
                .addPiece(Pieces.BOW, IDs.JP_DD_A_0_BOW_ID.getId(), null, null, new BlockPos(3, 0, 32), 1.0F)
                .addPiece(Pieces.GUN1, IDs.JP_DD_A_0_GUN_ID.getId(), null, null, new BlockPos(5, 10, 37), 1.0F)

                .addPiece(Pieces.MIDFRONT, IDs.JP_DD_A_0_MIDFRONT_ID.getId(), null, null, new BlockPos(2, 0, 0), 1.0F)
                .addPiece(Pieces.FOREMAST, IDs.JP_DD_A_0_FOREMAST_ID.getId(), null, null, new BlockPos(3, 7, 16), 1.0F)
                .addPiece(Pieces.TORPEDO1, IDs.JP_DD_A_0_TORPEDO_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(9, 8, 8), 1.0F)

                .addPiece(Pieces.MIDBACK, IDs.JP_DD_A_0_MIDBACK_ID.getId(), null, null, new BlockPos(2, 0, -32), 1.0F)
                .addPiece(Pieces.TORPEDO2, IDs.JP_DD_A_0_TORPEDO_ID.getId(), null, null, new BlockPos(5, 7, -20), 1.0F)
                .addPiece(Pieces.MAINMAST, IDs.JP_DD_A_0_MAINMAST_ID.getId(), null, null, new BlockPos(4, 9, -28), 1.0F)

                .addPiece(Pieces.STERN, IDs.JP_DD_A_0_STERN_ID.getId(), null, null, new BlockPos(3, 0, -60), 1.0F)
                .addPiece(Pieces.GUN2, IDs.JP_DD_A_0_GUN_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(9, 7, -35), 1.0F);
    }

    public static final StructureSunkenDestroyerA structureSunkenDestroyerA1;
    static
    {
        structureSunkenDestroyerA1 = new StructureSunkenDestroyerA();

        structureSunkenDestroyerA1
                .addPiece(Pieces.BOW, IDs.JP_DD_A_1_BOW_ID.getId(), null, null, new BlockPos(2, 1, 32), 1.0F)
                .addPiece(Pieces.GUN1, IDs.JP_DD_A_1_GUN_ID.getId(), null, null, new BlockPos(12, 3, 37), 1.0F)

                .addPiece(Pieces.MIDFRONT, IDs.JP_DD_A_1_MIDFRONT_ID.getId(), null, null, new BlockPos(2, 0, 0), 1.0F)
                .addPiece(Pieces.FOREMAST, IDs.JP_DD_A_1_FOREMAST_ID.getId(), null, null, new BlockPos(9, 1, 16), 1.0F)
                .addPiece(Pieces.TORPEDO1, IDs.JP_DD_A_1_TORPEDO_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(10, 3, 8), 1.0F)

                .addPiece(Pieces.MIDBACK, IDs.JP_DD_A_1_MIDBACK_ID.getId(), null, null, new BlockPos(2, 0, -32), 1.0F)
                .addPiece(Pieces.TORPEDO2, IDs.JP_DD_A_1_TORPEDO_ID.getId(), null, null, new BlockPos(9, 3, -20), 1.0F)
                .addPiece(Pieces.MAINMAST, IDs.JP_DD_A_1_MAINMAST_ID.getId(), null, null, new BlockPos(11, 4, -28), 1.0F)

                .addPiece(Pieces.STERN, IDs.JP_DD_A_1_STERN_ID.getId(), null, null, new BlockPos(2, 1, -60), 1.0F)
                .addPiece(Pieces.GUN2, IDs.JP_DD_A_2_GUN_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(9, 3, -35), 1.0F);
    }

    public static final StructureSunkenDestroyerA structureSunkenDestroyerA2;
    static
    {
        structureSunkenDestroyerA2 = new StructureSunkenDestroyerA();

        structureSunkenDestroyerA2
                .addPiece(Pieces.BOW, IDs.JP_DD_A_1_BOW_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 1, 32), 1.0F)
                .addPiece(Pieces.GUN1, IDs.JP_DD_A_2_GUN_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(2, 3, 37), 1.0F)

                .addPiece(Pieces.MIDFRONT, IDs.JP_DD_A_1_MIDFRONT_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 0, 0), 1.0F)
                .addPiece(Pieces.FOREMAST, IDs.JP_DD_A_1_FOREMAST_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(5, 1, 16), 1.0F)
                .addPiece(Pieces.TORPEDO1, IDs.JP_DD_A_1_TORPEDO_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(4, 3, 8), 1.0F)

                .addPiece(Pieces.MIDBACK, IDs.JP_DD_A_2_MIDBACK_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 0, -32), 1.0F)
                .addPiece(Pieces.TORPEDO2, IDs.JP_DD_A_1_TORPEDO_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(5, 3, -20), 1.0F)
                .addPiece(Pieces.MAINMAST, IDs.JP_DD_A_1_MAINMAST_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(3, 2, -28), 1.0F)

                .addPiece(Pieces.STERN, IDs.JP_DD_A_1_STERN_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 1, -60), 1.0F)
                .addPiece(Pieces.GUN2, IDs.JP_DD_A_1_GUN_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(5, 3, -35), 1.0F);
    }

    public static final StructureSunkenDestroyerA[] structures = {structureSunkenDestroyerA0, structureSunkenDestroyerA1, structureSunkenDestroyerA2};

    public StructureSunkenDestroyerA()
    {

    }

}
