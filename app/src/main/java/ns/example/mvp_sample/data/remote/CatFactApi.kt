package ns.example.mvp_sample.data.remote

import io.reactivex.Single
import ns.example.mvp_sample.data.entity.ApiResponse
import ns.example.mvp_sample.data.entity.CatFact

interface CatFactApi {
    fun get(): Single<ApiResponse<CatFact>>
}