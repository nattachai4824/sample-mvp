package ns.example.mvp_sample.ui.facts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cat_fact.*
import ns.example.mvp_sample.R
import ns.example.mvp_sample.data.entity.Fact
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton

class CatFactActivity : AppCompatActivity(), CatFactView {

    private val mPresenter = CatFactPresenterView()

    private val mCatFacts = mutableListOf<Fact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_fact)

        mPresenter.init(this)
        initView()

        mPresenter.requestCatFacts()
    }

    private fun initView() {
        with(rvFact) {
            layoutManager = LinearLayoutManager(this@CatFactActivity)
            adapter = CatFactAdapter(mCatFacts)
        }
    }

    override fun updateContent(catFacts: List<Fact>) {
        mCatFacts.addAll(catFacts)
        rvFact.adapter?.notifyDataSetChanged()
    }

    override fun showContentLoading() {
        srlContent.isRefreshing = true
    }

    override fun dismissContentLoading() {
        srlContent.isRefreshing = false
    }

    override fun showRequestFailure() {
        alert("Request Failure. Please try again later") {
            okButton {

            }
        }.show()
    }

    override fun showInitializationFailure() {
        alert("Components not initialized") {
            okButton {

            }
        }.show()
    }
}