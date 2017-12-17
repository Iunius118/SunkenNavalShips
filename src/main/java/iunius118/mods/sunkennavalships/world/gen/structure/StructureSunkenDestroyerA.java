package iunius118.mods.sunkennavalships.world.gen.structure;

import java.util.HashMap;
import java.util.Map;

import iunius118.mods.sunkennavalships.SunkenNavalShips;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class StructureSunkenDestroyerA
{

    public enum Pieces
    {
        BOW, GUN1, MIDFRONT, FOREMAST, TORPEDO1, MIDBACK, TORPEDO2, MAINMAST, STERN, GUN2;
    }

    public enum IDs
    {

        JP_DD_A_0_BOW_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_bow")),
        JP_DD_A_0_MIDFRONT_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_midfront")),
        JP_DD_A_0_MIDBACK_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_midback")),
        JP_DD_A_0_STERN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_stern")),
        JP_DD_A_0_FOREMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_foremast")),
        JP_DD_A_0_MAINMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_mainmast")),
        JP_DD_A_0_FOREMAST_BROKEN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_foremast_broken")),
        JP_DD_A_0_GUN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_gun")),
        JP_DD_A_0_TORPEDO_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_0_torpedo")),

        JP_DD_A_1_BOW_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_1_bow")),
        JP_DD_A_1_MIDFRONT_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_1_midfront")),
        JP_DD_A_1_MIDBACK_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_1_midback")),
        JP_DD_A_1_STERN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_1_stern")),
        JP_DD_A_1_FOREMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_1_foremast")),
        JP_DD_A_1_MAINMAST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a/jp_dd_a_1_mainmast")),
        JP_DD_A_1_FOREMAST_BROKEN_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "jp_dd_a_jp_dd_a_1_foremast_broken")),
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

    public final Map<Pieces, Piece> pieces = new HashMap();

    public static final StructureSunkenDestroyerA structureSunkenDestroyerA0;
    static
    {
        structureSunkenDestroyerA0 = new StructureSunkenDestroyerA();

        structureSunkenDestroyerA0.pieces.put(Pieces.BOW, new Piece(IDs.JP_DD_A_0_BOW_ID.getId(), null, null, new BlockPos(3, 0, 32), 1.0F));
        structureSunkenDestroyerA0.pieces.put(Pieces.GUN1, new Piece(IDs.JP_DD_A_0_GUN_ID.getId(), null, null, new BlockPos(5, 10, 37), 1.0F));

        structureSunkenDestroyerA0.pieces.put(Pieces.MIDFRONT, new Piece(IDs.JP_DD_A_0_MIDFRONT_ID.getId(), null, null, new BlockPos(2, 0, 0), 1.0F));
        structureSunkenDestroyerA0.pieces.put(Pieces.FOREMAST, new Piece(IDs.JP_DD_A_0_FOREMAST_ID.getId(), null, null, new BlockPos(3, 7, 16), 1.0F));
        structureSunkenDestroyerA0.pieces.put(Pieces.TORPEDO1, new Piece(IDs.JP_DD_A_0_TORPEDO_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(9, 8, 8), 1.0F));

        structureSunkenDestroyerA0.pieces.put(Pieces.MIDBACK, new Piece(IDs.JP_DD_A_0_MIDBACK_ID.getId(), null, null, new BlockPos(2, 0, -32), 1.0F));
        structureSunkenDestroyerA0.pieces.put(Pieces.TORPEDO2, new Piece(IDs.JP_DD_A_0_TORPEDO_ID.getId(), null, null, new BlockPos(5, 7, -20), 1.0F));
        structureSunkenDestroyerA0.pieces.put(Pieces.MAINMAST, new Piece(IDs.JP_DD_A_0_MAINMAST_ID.getId(), null, null, new BlockPos(4, 9, -28), 1.0F));

        structureSunkenDestroyerA0.pieces.put(Pieces.STERN, new Piece(IDs.JP_DD_A_0_STERN_ID.getId(), null, null, new BlockPos(3, 0, -60), 1.0F));
        structureSunkenDestroyerA0.pieces.put(Pieces.GUN2, new Piece(IDs.JP_DD_A_0_GUN_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(9, 7, -35), 1.0F));
    }

    public static final StructureSunkenDestroyerA structureSunkenDestroyerA1;
    static
    {
        structureSunkenDestroyerA1 = new StructureSunkenDestroyerA();

        structureSunkenDestroyerA1.pieces.put(Pieces.BOW, new Piece(IDs.JP_DD_A_1_BOW_ID.getId(), null, null, new BlockPos(2, 1, 32), 1.0F));
        structureSunkenDestroyerA1.pieces.put(Pieces.GUN1, new Piece(IDs.JP_DD_A_1_GUN_ID.getId(), null, null, new BlockPos(12, 3, 37), 1.0F));

        structureSunkenDestroyerA1.pieces.put(Pieces.MIDFRONT, new Piece(IDs.JP_DD_A_1_MIDFRONT_ID.getId(), null, null, new BlockPos(2, 0, 0), 1.0F));
        structureSunkenDestroyerA1.pieces.put(Pieces.FOREMAST, new Piece(IDs.JP_DD_A_1_FOREMAST_ID.getId(), null, null, new BlockPos(9, 1, 16), 1.0F));
        structureSunkenDestroyerA1.pieces.put(Pieces.TORPEDO1, new Piece(IDs.JP_DD_A_1_TORPEDO_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(10, 3, 8), 1.0F));

        structureSunkenDestroyerA1.pieces.put(Pieces.MIDBACK, new Piece(IDs.JP_DD_A_1_MIDBACK_ID.getId(), null, null, new BlockPos(2, 0, -32), 1.0F));
        structureSunkenDestroyerA1.pieces.put(Pieces.TORPEDO2, new Piece(IDs.JP_DD_A_1_TORPEDO_ID.getId(), null, null, new BlockPos(9, 3, -20), 1.0F));
        structureSunkenDestroyerA1.pieces.put(Pieces.MAINMAST, new Piece(IDs.JP_DD_A_1_MAINMAST_ID.getId(), null, null, new BlockPos(11, 4, -28), 1.0F));

        structureSunkenDestroyerA1.pieces.put(Pieces.STERN, new Piece(IDs.JP_DD_A_1_STERN_ID.getId(), null, null, new BlockPos(2, 1, -60), 1.0F));
        structureSunkenDestroyerA1.pieces.put(Pieces.GUN2, new Piece(IDs.JP_DD_A_2_GUN_ID.getId(), Mirror.LEFT_RIGHT, null, new BlockPos(9, 3, -35), 1.0F));
    }

    public static final StructureSunkenDestroyerA structureSunkenDestroyerA2;
    static
    {
        structureSunkenDestroyerA2 = new StructureSunkenDestroyerA();

        structureSunkenDestroyerA2.pieces.put(Pieces.BOW, new Piece(IDs.JP_DD_A_1_BOW_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 1, 32), 1.0F));
        structureSunkenDestroyerA2.pieces.put(Pieces.GUN1, new Piece(IDs.JP_DD_A_2_GUN_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(2, 3, 37), 1.0F));

        structureSunkenDestroyerA2.pieces.put(Pieces.MIDFRONT, new Piece(IDs.JP_DD_A_1_MIDFRONT_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 0, 0), 1.0F));
        structureSunkenDestroyerA2.pieces.put(Pieces.FOREMAST, new Piece(IDs.JP_DD_A_1_FOREMAST_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(5, 1, 16), 1.0F));
        structureSunkenDestroyerA2.pieces.put(Pieces.TORPEDO1, new Piece(IDs.JP_DD_A_1_TORPEDO_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(4, 3, 8), 1.0F));

        structureSunkenDestroyerA2.pieces.put(Pieces.MIDBACK, new Piece(IDs.JP_DD_A_2_MIDBACK_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 0, -32), 1.0F));
        structureSunkenDestroyerA2.pieces.put(Pieces.TORPEDO2, new Piece(IDs.JP_DD_A_1_TORPEDO_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(5, 3, -20), 1.0F));
        structureSunkenDestroyerA2.pieces.put(Pieces.MAINMAST, new Piece(IDs.JP_DD_A_1_MAINMAST_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(3, 2, -28), 1.0F));

        structureSunkenDestroyerA2.pieces.put(Pieces.STERN, new Piece(IDs.JP_DD_A_1_STERN_ID.getId(), Mirror.FRONT_BACK, null, new BlockPos(12, 1, -60), 1.0F));
        structureSunkenDestroyerA2.pieces.put(Pieces.GUN2, new Piece(IDs.JP_DD_A_1_GUN_ID.getId(), null, Rotation.CLOCKWISE_180, new BlockPos(5, 3, -35), 1.0F));
    }

    public static final StructureSunkenDestroyerA[] structures = {structureSunkenDestroyerA0, structureSunkenDestroyerA1, structureSunkenDestroyerA2};

    public StructureSunkenDestroyerA()
    {

    }

    public void addBlocksToWorld(World world, BlockPos pos, EnumFacing facing, PlacementSettings placement)
    {
        for (Piece piece : pieces.values())
        {
            piece.addBlocksToWorld(world, pos, facing, placement);
        }
    }

    public static class Piece
    {

        public ResourceLocation id;
        public Mirror mirror;
        public Rotation rotation;
        public BlockPos offset;
        public float integrity;

        public Piece(ResourceLocation idIn, Mirror mirrorIn, Rotation rotationIn, BlockPos offsetIn, float integrityIn)
        {
            id = idIn;
            mirror = (mirrorIn != null) ? mirrorIn : Mirror.NONE;
            rotation = (rotationIn != null) ? rotationIn : Rotation.NONE;
            offset = offsetIn;
            integrity = integrityIn;
        }

        public Piece copy()
        {
            return new Piece(id, mirror, rotation, offset, integrity);
        }

        public Piece setId(ResourceLocation idIn)
        {
            id = idIn;
            return this;
        }

        public Piece setMirror(Mirror mirrorIn)
        {
            mirror = mirrorIn;
            return this;
        }

        public Piece setRotation(Rotation rotationIn)
        {
            rotation = rotationIn;
            return this;
        }

        public Piece setOffset(BlockPos offsetIn)
        {
            offset = offsetIn;
            return this;
        }

        public Piece addOffset(BlockPos offsetIn)
        {
            offset = new BlockPos(offset).add(offsetIn);
            return this;
        }

        public Piece setIntegrity(float integrityIn)
        {
            integrity = integrityIn;
            return this;
        }

        public void addBlocksToWorld(World world, BlockPos pos, EnumFacing facing, PlacementSettings placement)
        {
            BlockPos fixedPos;
            PlacementSettings fixedPlacement = placement.copy().setIntegrity(integrity);

            if (fixedPlacement.getMirror() == Mirror.NONE)
            {
                fixedPlacement.setMirror(mirror);
            }
            else if (fixedPlacement.getMirror() == mirror)
            {
                fixedPlacement.setMirror(Mirror.NONE);
            }
            else if (mirror != Mirror.NONE)
            {
                fixedPlacement.setMirror(Mirror.NONE);
                fixedPlacement.setRotation(fixedPlacement.getRotation().add(Rotation.CLOCKWISE_180));
            }

            switch (facing)
            {
            case EAST:
                fixedPos = new BlockPos(offset.getZ(), offset.getY(), -offset.getX()).add(pos).add(0, 0, 15);
                fixedPlacement.setRotation(fixedPlacement.getRotation().add(Rotation.COUNTERCLOCKWISE_90).add(rotation));
                break;

            case NORTH:
                fixedPos = new BlockPos(-offset.getX(), offset.getY(), -offset.getZ()).add(pos).add(15, 0, 15);
                fixedPlacement.setRotation(fixedPlacement.getRotation().add(Rotation.CLOCKWISE_180).add(rotation));
                break;

            case WEST:
                fixedPos = new BlockPos(-offset.getZ(), offset.getY(), offset.getX()).add(pos).add(15, 0, 0);
                fixedPlacement.setRotation(fixedPlacement.getRotation().add(Rotation.CLOCKWISE_90).add(rotation));
                break;

            default:
                fixedPos = offset.add(pos);
                fixedPlacement.setRotation(fixedPlacement.getRotation().add(rotation));
                break;

            }

            TemplateManager templatemanager = world.getSaveHandler().getStructureTemplateManager();
            MinecraftServer minecraftserver = world.getMinecraftServer();
            Template template = templatemanager.getTemplate(minecraftserver, id);
            template.addBlocksToWorld(world, fixedPos, fixedPlacement);
        }

    }
}
