package iunius118.mods.sunkennavalships.world.gen.structure;

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

public class Piece
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
