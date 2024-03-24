package com.whitegold.clusteryaprofi.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "cluster")
data class Cluster(
    @Id
    val id: Long? = null,
    @Column
    val size: Int? = null,
    @Column
    val task: String? = null
)