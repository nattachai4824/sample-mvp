package ns.example.mvp_sample.ui.facts

import ns.example.mvp_sample.data.remote.CatFactApi
import ns.example.mvp_sample.data.remote.impl.CatFactApiImpl

class CatFactPresenterView : CatFactPresenter {

    private var catFactApi: CatFactApi? = null
    private lateinit var mView: CatFactView

    fun init(view: CatFactView) {
        mView = view
        catFactApi = CatFactApiImpl()
    }

    override fun requestCatFacts() {
        catFactApi?.let { catFactApi ->

            mView.showContentLoading()

            catFactApi.get().subscribe({ apiResponse ->
                mView.dismissContentLoading()

                val data = apiResponse.data
                data?.let {
                    mView.updateContent(it.facts)
                } ?: {
                    mView.showRequestFailure()
                }()
            }, {})
        } ?: {
           mView.showInitializationFailure()
        }()
    }
}