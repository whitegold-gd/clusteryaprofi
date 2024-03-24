package com.whitegold.clusteryaprofi.service

import com.whitegold.clusteryaprofi.dto.ResultRequest
import com.whitegold.clusteryaprofi.dto.ResultResponse
import com.whitegold.clusteryaprofi.dto.ResultResponseWithoutHost
import com.whitegold.clusteryaprofi.model.Cluster
import com.whitegold.clusteryaprofi.repository.ClusterRepository
import org.springframework.stereotype.Service

@Service
class ClusterService (
    val clusterRepository: ClusterRepository
) {
    fun save(request: ResultRequest): Any {
        val result = clusterRepository.save(mapToCluster(request))
        //Далее необходимо осуществить запрос на проверку доступности серверов.
        //Если машина готова принять задачу, необходимо отправить соответствующий
        //запрос и получить ответ
        return if (request.id == 1.toLong()) mapToResponse(result)
        else mapToResponseWithoutHost(result)
    }

    fun mapToCluster(request: ResultRequest): Cluster{
        return Cluster(
            request.id,
            request.size,
            request.task
        )
    }

    fun mapToResponse(cluster: Cluster): ResultResponse{
        return ResultResponse(
            result = "OK",
            host_id = cluster.id,
        )
    }

    fun mapToResponseWithoutHost(cluster: Cluster): ResultResponseWithoutHost{
        return ResultResponseWithoutHost(
            result = "NOT_OK"
        )
    }

}