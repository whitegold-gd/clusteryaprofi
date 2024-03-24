package com.whitegold.clusteryaprofi.repository

import com.whitegold.clusteryaprofi.model.Cluster
import org.springframework.data.jpa.repository.JpaRepository

interface ClusterRepository: JpaRepository<Cluster, Long> {
}