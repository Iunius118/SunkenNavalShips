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

public class StructureSunkenShip
{

    public final Map<Object, Piece> pieces = new HashMap<Object, Piece>();

    public enum Pieces
    {
        TEST;
    }

    public enum IDs
    {

        TEST_ID(new ResourceLocation(SunkenNavalShips.MOD_ID, "nbt_test"));

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

    public static final StructureSunkenShip structureTest;
    static
    {
        structureTest = new StructureSunkenShip();

        structureTest
                .addPiece(Pieces.TEST, IDs.TEST_ID.getId(), null, null, new BlockPos(0, 0, 0), 1.0F);
    }

    public StructureSunkenShip addPiece(Object pieceID, ResourceLocation idIn, Mirror mirrorIn, Rotation rotationIn, BlockPos offsetIn, float integrityIn)
    {
        pieces.put(pieceID, new Piece(idIn, mirrorIn, rotationIn, offsetIn, integrityIn));
        return this;
    }

    public StructureSunkenShip addPieceFromStructures(Object pieceID, StructureSunkenShip[] structures, int capsizing, BlockPos offset)
    {
        pieces.put(pieceID, structures[capsizing].pieces.get(pieceID).copy().addOffset(offset));
        return this;
    }

    public StructureSunkenShip addPieceFromStructures(Object pieceID, StructureSunkenShip[] structures, int capsizing, BlockPos offset, float integrity)
    {
        pieces.put(pieceID, structures[capsizing].pieces.get(pieceID).copy().addOffset(offset).setIntegrity(integrity));
        return this;
    }

    public void addBlocksToWorld(World world, BlockPos pos, EnumFacing facing, PlacementSettings placement)
    {
        for (Piece piece : pieces.values())
        {
            piece.addBlocksToWorld(world, pos, facing, placement);
        }
    }

}
