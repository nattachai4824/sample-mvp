package ns.example.mvp_sample.data.entity

data class ApiResponse<T>(
    val data: T?,
    val errorResponse: ApiErrorResponse?
)