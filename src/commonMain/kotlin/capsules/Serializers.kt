package com.haroldadmin.spacexkmp.capsules

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal class CapsuleStatusSerializer : KSerializer<CapsuleStatus> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("CapsuleStatus", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): CapsuleStatus {
        val status = decoder.decodeString()
        return CapsuleStatus.values().find { it.status == status }
            ?: throw IllegalArgumentException("Can't map $status to CapsuleStatus")
    }

    override fun serialize(encoder: Encoder, value: CapsuleStatus) {
        encoder.encodeString(value.status)
    }
}

internal class DragonTypeSerializer : KSerializer<DragonType> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("DragonType", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): DragonType {
        val type = decoder.decodeString()
        return DragonType.values().find { it.type == type }
            ?: throw IllegalArgumentException("Can't map $type to DragonType")
    }

    override fun serialize(encoder: Encoder, value: DragonType) {
        encoder.encodeString(value.type)
    }

}