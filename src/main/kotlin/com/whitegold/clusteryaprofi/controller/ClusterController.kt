package com.whitegold.clusteryaprofi.controller

import com.whitegold.clusteryaprofi.dto.ResultRequest
import com.whitegold.clusteryaprofi.dto.ResultResponse
import com.whitegold.clusteryaprofi.service.ClusterService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ClusterController (
    val clusterService: ClusterService
) {
    @GetMapping("/result")
    fun getResultFromMachine(@RequestBody request: ResultRequest): ResponseEntity<Any>{
        val response = clusterService.save(request)
        return if (request.id == 1.toLong()){
            ResponseEntity(response, HttpStatus.OK)
        } else {
            ResponseEntity(response, HttpStatus.NOT_ACCEPTABLE)
        }
    }


}