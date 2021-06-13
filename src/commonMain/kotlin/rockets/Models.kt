package com.haroldadmin.spacexkmp.rockets

import com.haroldadmin.spacexkmp.common.Length
import com.haroldadmin.spacexkmp.common.Mass
import com.haroldadmin.spacexkmp.common.Thrust
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PayloadWeight(
    val id: String?,
    val name: String?,
    val kg: Double?,
    val lb: Double?
)

@Serializable
public data class FirstStage(
    val reusable: Boolean?,
    val engines: Int?,
    @SerialName("fuel_amount_tons")
    val fuelAmountTons: Double?,
    @SerialName("burn_time_sec")
    val burnTimeSec: Double?,
    @SerialName("thrust_sea_level")
    val thrustSeaLevel: Thrust?,
    @SerialName("thrust_vacuum")
    val thrustVacuum: Thrust?
)

@Serializable
public data class CompositeFairing(
    val height: Length?,
    val diameter: Length?
)

@Serializable
public data class SecondStagePayloads(
    @SerialName("option_1")
    val option1: String?,
    @SerialName("composite_fairing")
    val compositeFairing: CompositeFairing?
)

@Serializable
public data class SecondStage(
    val reusable: Boolean?,
    val engines: Int?,
    @SerialName("fuel_amount_tons")
    val fuelAmountTons: Double?,
    @SerialName("burn_time_sec")
    val burnTimeSec: Double?,
    val thrust: Thrust?,
    val payloads: SecondStagePayloads,
)

@Serializable
public data class ISP(
    @SerialName("sea_level")
    val seaLevel: Double?,
    val vacuum: Double?
)

@Serializable
public data class Engines(
    val number: Int?,
    val type: String?,
    val version: String?,
    val layout: String?,
    val isp: ISP,
    @SerialName("engine_loss_max")
    val engineLossMax: Int?,
    @SerialName("propellant_1")
    val propellantOne: String?,
    @SerialName("propellant_2")
    val propellantTwo: String?,
    @SerialName("thrust_sea_level")
    val thrustSeaLevel: Thrust?,
    @SerialName("thrust_vacuum")
    val thrustVacuum: Thrust?,
    @SerialName("thrust_to_weight")
    val thrustToWeight: Double?
)

@Serializable
public data class LandingLegs(
    val number: Int?,
    val material: String?
)

@Serializable
public data class Rocket(
    val id: String,
    val name: String?,
    val type: String?,
    val active: Boolean?,
    val stages: Int?,
    val boosters: Int?,
    @SerialName("cost_per_launch")
    val costPerLaunch: Double?,
    @SerialName("success_rate_pct")
    val successRatePercentage: Double?,
    @SerialName("first_flight")
    val firstFlight: String?,
    val country: String?,
    val company: String?,
    val height: Length?,
    val diameter: Length?,
    val mass: Mass?,
    @SerialName("payload_weights")
    val payloadWeights: List<PayloadWeight>?,
    @SerialName("first_stage")
    val firstStage: FirstStage?,
    @SerialName("second_stage")
    val secondStage: SecondStage,
    val engines: Engines,
    @SerialName("landing_legs")
    val landingLegs: LandingLegs,
    @SerialName("flickr_images")
    val flickrImages: List<String>?,
    val wikipedia: String?,
    val description: String?
)
