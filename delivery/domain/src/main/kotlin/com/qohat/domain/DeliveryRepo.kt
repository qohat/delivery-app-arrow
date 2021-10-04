package com.qohat.domain

import com.qohat.DeliveryDSL

interface DeliveryRepo {
    suspend fun findAll(): List<DeliveryDSL.Location>
}