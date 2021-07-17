package daniking.throwabletorch.common.network.packet;
import daniking.throwabletorch.common.ThrowableTorch;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.impl.networking.ServerSidePacketRegistryImpl;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

public class EntitySpawnPacket {

    public static final Identifier ID = new Identifier(ThrowableTorch.MODID, "throwable_torch");

    public static Packet<?> create(Entity entity) {
        if (entity.world.isClient) {
            throw new IllegalStateException("SpawnPacketUtil.create called on the logical client!");
        }
        PacketByteBuf byteBuf = new PacketByteBuf(Unpooled.buffer());
        byteBuf.writeVarInt(Registry.ENTITY_TYPE.getRawId(entity.getType()));
        byteBuf.writeUuid(entity.getUuid());
        byteBuf.writeVarInt(entity.getId());

        PacketBufUtil.writeVec3d(byteBuf, entity.getPos());
        PacketBufUtil.writeAngle(byteBuf, entity.getPitch());
        PacketBufUtil.writeAngle(byteBuf, entity.getYaw());
        return ServerSidePacketRegistryImpl.INSTANCE.toPacket(ID, byteBuf);
    }
    public static final class PacketBufUtil {

        /**
         * Packs a floating-point angle into a {@code byte}.
         *
         * @param angle
         *         angle
         * @return packed angle
         */
        public static byte packAngle(float angle) {
            return (byte) MathHelper.floor(angle * 256 / 360);
        }

        /**
         * Unpacks a floating-point angle from a {@code byte}.
         *
         * @param angleByte
         *         packed angle
         * @return angle
         */
        public static float unpackAngle(byte angleByte) {
            return (angleByte * 360) / 256f;
        }

        /**
         * Writes an angle to a {@link PacketByteBuf}.
         *
         * @param byteBuf
         *         destination buffer
         * @param angle
         *         angle
         */
        public static void writeAngle(PacketByteBuf byteBuf, float angle) {
            byteBuf.writeByte(packAngle(angle));
        }

        /**
         * Reads an angle from a {@link PacketByteBuf}.
         *
         * @param byteBuf
         *         source buffer
         * @return angle
         */
        public static float readAngle(PacketByteBuf byteBuf) {
            return unpackAngle(byteBuf.readByte());
        }

        /**
         * Writes a {@link Vec3d} to a {@link PacketByteBuf}.
         *
         * @param byteBuf
         *         destination buffer
         * @param vec3d
         *         vector
         */
        public static void writeVec3d(PacketByteBuf byteBuf, Vec3d vec3d) {
            byteBuf.writeDouble(vec3d.x);
            byteBuf.writeDouble(vec3d.y);
            byteBuf.writeDouble(vec3d.z);
        }

        /**
         * Reads a {@link Vec3d} from a {@link PacketByteBuf}.
         *
         * @param byteBuf
         *         source buffer
         * @return vector
         */
        public static Vec3d readVec3d(PacketByteBuf byteBuf) {
            double x = byteBuf.readDouble();
            double y = byteBuf.readDouble();
            double z = byteBuf.readDouble();
            return new Vec3d(x, y, z);
        }
    }
}

