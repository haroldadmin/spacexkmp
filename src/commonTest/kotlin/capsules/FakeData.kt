package com.haroldadmin.spacexkmp.capsules

val FakeCapsuleResponse = """
    {
        "reuse_count": 1,
        "water_landings": 1,
        "land_landings": 0,
        "last_update": "Reentered after three weeks in orbit",
        "launches": [
        "5eb87cdeffd86e000604b330"
        ],
        "serial": "C101",
        "status": "retired",
        "type": "Dragon 1.0",
        "id": "5e9e2c5bf35918ed873b2664"
    }
""".trimIndent()

val FakeCapsulesResponse = """
    [
        {
            "reuse_count": 1,
            "water_landings": 1,
            "land_landings": 0,
            "last_update": "Reentered after three weeks in orbit",
            "launches": [
                "5eb87cdeffd86e000604b330"
            ],
            "serial": "C101",
            "status": "retired",
            "type": "Dragon 1.0",
            "id": "5e9e2c5bf35918ed873b2664"
        }
    ]
""".trimIndent()