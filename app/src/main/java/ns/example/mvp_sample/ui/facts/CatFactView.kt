package ns.example.mvp_sample.ui.facts

import ns.example.mvp_sample.data.entity.Fact

interface CatFactView {
    fun updateContent(catFacts: List<Fact>)
    fun showContentLoading()
    fun dismissContentLoading()
    fun showRequestFailure()
    fun showInitializationFailure()
}