package iunius118.mods.sunkennavalships.world.gen;

import net.minecraft.util.math.BlockPos;

public class Section
{

    public boolean canGenerate;
    public BlockPos offset;
    public int capsizing;

    public Section(boolean canGenerateIn, BlockPos offsetIn, int capsizingIn)
    {
        canGenerate = canGenerateIn;
        offset = offsetIn;
        capsizing = capsizingIn;
    }

}
