package iunius118.mods.sunkennavalships.world.gen.structure;

import java.util.HashMap;
import java.util.Map;

import iunius118.mods.sunkennavalships.SunkenNavalShips;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.PlacementSettings;

public class StructureSunkenDestroyerB
{

    public enum Pieces
    {
        BOW, GUN1, MIDFRONT, FOREMAST, TORPEDO1, MIDBACK, TORPEDO2, STERN, MAINMAST, GUN2, GUN3;
    }

    public enum IDs
    {

        DE_DD_Z23_0_BOW_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_0_bow")),
        DE_DD_Z23_0_MIDFRONT_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_0_midfront")),
        DE_DD_Z23_0_MIDBACK_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_0_midback")),
        DE_DD_Z23_0_STERN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_0_stern")),
        DE_DD_Z23_0_FOREMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_0_foremast")),
        DE_DD_Z23_0_MAINMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_0_mainmast")),
        DE_DD_Z23_0_GUN_A_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_0_gun_a")),
        DE_DD_Z23_0_GUN_B_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_0_gun_b")),
        DE_DD_Z23_0_TORPEDO_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_0_torpedo")),

        DE_DD_Z23_1_BOW_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_1_bow")),
        DE_DD_Z23_1_MIDFRONT_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_1_midfront")),
        DE_DD_Z23_1_MIDBACK_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_1_midback")),
        DE_DD_Z23_1_STERN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_1_stern")),
        DE_DD_Z23_1_FOREMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_1_foremast")),
        DE_DD_Z23_1_MAINMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_1_mainmast")),
        DE_DD_Z23_1_GUN_A_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_1_gun_a")),
        DE_DD_Z23_1_GUN_B_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_1_gun_b")),
        DE_DD_Z23_1_TORPEDO_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_1_torpedo")),

        DE_DD_Z23_2_MIDFRONT_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_2_midfront")),
        DE_DD_Z23_2_MIDBACK_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "de_dd_z23/de_dd_z23_2_midback"));

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

    public final Map<Pieces, Piece> pieces = new HashMap();

    public static final StructureSunkenDestroyerB structureSunkenDestroyerB0;
    static
    {
        structureSunkenDestroyerB0 = new StructureSunkenDestroyerB();

        structureSunkenDestroyerB0.pieces.put(Pieces.BOW, new Piece(IDs.DE_DD_Z23_0_BOW_ID.getId(), null, null, new BlockPos(3, 0, 32), 1.0F));
        structureSunkenDestroyerB0.pieces.put(Pieces.GUN1, new Piece(IDs.DE_DD_Z23_0_GUN_A_ID.getId(), null, null, new BlockPos(5, 10, 37), 1.0F));

        structureSunkenDestroyerB0.pieces.put(Pieces.MIDFRONT, new Piece(IDs.DE_DD_Z23_0_MIDFRONT_ID.getId(), null, null, new BlockPos(2, 0, 0), 1.0F));
        structureSunkenDestroyerB0.pieces.put(Pieces.FOREMAST, new Piece(IDs.DE_DD_Z23_0_FOREMAST_ID.getId(), null, null, new BlockPos(4, 10, 16), 1.0F));
        structureSunkenDestroyerB0.pieces.put(Pieces.TORPEDO1, new Piece(IDs.DE_DD_Z23_0_TORPEDO_ID.getId(), null, null, new BlockPos(6, 8, 0), 1.0F));

        structureSunkenDestroyerB0.pieces.put(Pieces.MIDBACK, new Piece(IDs.DE_DD_Z23_0_MIDBACK_ID.getId(), null, null, new BlockPos(2, 0, -32), 1.0F));
        structureSunkenDestroyerB0.pieces.put(Pieces.TORPEDO2, new Piece(IDs.DE_DD_Z23_0_TORPEDO_ID.getId(), null, null, new BlockPos(6, 8, -25), 1.0F));

        structureSunkenDestroyerB0.pieces.put(Pieces.STERN, new Piece(IDs.DE_DD_Z23_0_STERN_ID.getId(), null, null, new BlockPos(3, 0, -64), 1.0F));
        structureSunkenDestroyerB0.pieces.put(Pieces.MAINMAST, new Piece(IDs.DE_DD_Z23_0_MAINMAST_ID.getId(), null, null, new BlockPos(5, 10, -37), 1.0F));
        structureSunkenDestroyerB0.pieces.put(Pieces.GUN2, new Piece(IDs.DE_DD_Z23_0_GUN_B_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(6, 10, -41), 1.0F));
        structureSunkenDestroyerB0.pieces.put(Pieces.GUN3, new Piece(IDs.DE_DD_Z23_0_GUN_B_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(6, 7, -49), 1.0F));
    }

    public static final StructureSunkenDestroyerB structureSunkenDestroyerB1;
    static
    {
        structureSunkenDestroyerB1 = new StructureSunkenDestroyerB();

        structureSunkenDestroyerB1.pieces.put(Pieces.BOW, new Piece(IDs.DE_DD_Z23_1_BOW_ID.getId(), null, null, new BlockPos(2, 1, 32), 1.0F));
        structureSunkenDestroyerB1.pieces.put(Pieces.GUN1, new Piece(IDs.DE_DD_Z23_1_GUN_A_ID.getId(), null, null, new BlockPos(12, 3, 37), 1.0F));

        structureSunkenDestroyerB1.pieces.put(Pieces.MIDFRONT, new Piece(IDs.DE_DD_Z23_1_MIDFRONT_ID.getId(), null, null, new BlockPos(2, 0, 0), 1.0F));
        structureSunkenDestroyerB1.pieces.put(Pieces.FOREMAST, new Piece(IDs.DE_DD_Z23_1_FOREMAST_ID.getId(), null, null, new BlockPos(12, 2, 16), 1.0F));
        structureSunkenDestroyerB1.pieces.put(Pieces.TORPEDO1, new Piece(IDs.DE_DD_Z23_1_TORPEDO_ID.getId(), null, null, new BlockPos(10, 4, 0), 1.0F));

        structureSunkenDestroyerB1.pieces.put(Pieces.MIDBACK, new Piece(IDs.DE_DD_Z23_1_MIDBACK_ID.getId(), null, null, new BlockPos(2, 0, -32), 1.0F));
        structureSunkenDestroyerB1.pieces.put(Pieces.TORPEDO2, new Piece(IDs.DE_DD_Z23_1_TORPEDO_ID.getId(), null, null, new BlockPos(10, 4, -25), 1.0F));

        structureSunkenDestroyerB1.pieces.put(Pieces.STERN, new Piece(IDs.DE_DD_Z23_1_STERN_ID.getId(), null, null, new BlockPos(2, 1, -64), 1.0F));
        structureSunkenDestroyerB1.pieces.put(Pieces.MAINMAST, new Piece(IDs.DE_DD_Z23_1_MAINMAST_ID.getId(), null, null, new BlockPos(12, 3, -37), 1.0F));
        structureSunkenDestroyerB1.pieces.put(Pieces.GUN2, new Piece(IDs.DE_DD_Z23_1_GUN_B_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(12, 4, -41), 1.0F));
        structureSunkenDestroyerB1.pieces.put(Pieces.GUN3, new Piece(IDs.DE_DD_Z23_1_GUN_B_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(9, 4, -49), 1.0F));
    }

    public static final StructureSunkenDestroyerB structureSunkenDestroyerB2;
    static
    {
        structureSunkenDestroyerB2 = new StructureSunkenDestroyerB();

        structureSunkenDestroyerB2.pieces.put(Pieces.BOW, new Piece(IDs.DE_DD_Z23_1_BOW_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 1, 32), 1.0F));
        structureSunkenDestroyerB2.pieces.put(Pieces.GUN1, new Piece(IDs.DE_DD_Z23_1_GUN_A_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(2, 3, 37), 1.0F));

        structureSunkenDestroyerB2.pieces.put(Pieces.MIDFRONT, new Piece(IDs.DE_DD_Z23_2_MIDFRONT_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 0, 0), 1.0F));
        structureSunkenDestroyerB2.pieces.put(Pieces.FOREMAST, new Piece(IDs.DE_DD_Z23_1_FOREMAST_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(2, 2, 16), 1.0F));
        structureSunkenDestroyerB2.pieces.put(Pieces.TORPEDO1, new Piece(IDs.DE_DD_Z23_1_TORPEDO_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(4, 4, 0), 1.0F));

        structureSunkenDestroyerB2.pieces.put(Pieces.MIDBACK, new Piece(IDs.DE_DD_Z23_2_MIDBACK_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 0, -32), 1.0F));
        structureSunkenDestroyerB2.pieces.put(Pieces.TORPEDO2, new Piece(IDs.DE_DD_Z23_1_TORPEDO_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(4, 4, -25), 1.0F));

        structureSunkenDestroyerB2.pieces.put(Pieces.STERN, new Piece(IDs.DE_DD_Z23_1_STERN_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 1, -64), 1.0F));
        structureSunkenDestroyerB2.pieces.put(Pieces.MAINMAST, new Piece(IDs.DE_DD_Z23_1_MAINMAST_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(2, 3, -37), 1.0F));
        structureSunkenDestroyerB2.pieces.put(Pieces.GUN2, new Piece(IDs.DE_DD_Z23_1_GUN_B_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(2, 4, -41), 1.0F));
        structureSunkenDestroyerB2.pieces.put(Pieces.GUN3, new Piece(IDs.DE_DD_Z23_1_GUN_B_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(5, 4, -49), 1.0F));
    }

    public static final StructureSunkenDestroyerB[] structures = {structureSunkenDestroyerB0, structureSunkenDestroyerB1, structureSunkenDestroyerB2};

    public StructureSunkenDestroyerB()
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
