package com.ivantrogrlic.airquality.ui.home

import android.app.Activity
import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent.EXTRA_RESULTS
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.airquallity.ivan.persistentsearch.SearchBox
import com.airquallity.ivan.persistentsearch.SearchResult
import com.ivantrogrlic.airquality.R
import com.ivantrogrlic.airquality.model.Location
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import kotlinx.android.synthetic.main.home_screen.*
import javax.inject.Inject


/**
 * Created by ivan on 8/23/2017.
 */

class HomeActivity : AppCompatActivity(), HasFragmentInjector, HomeView {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        setupSearchBar()
        setupPagerAdapter()
    }

    override fun fragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == SearchBox.VOICE_RECOGNITION_CODE && resultCode == Activity.RESULT_OK) {
            val matches = data.getStringArrayListExtra(EXTRA_RESULTS)
            searchbox.populateEditText(matches[0])
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun citiesFound(locations: List<Location>) {
        searchbox.clearSearchable()
        locations.forEach {
            val option = SearchResult(it.location + ", " + it.city + ", " + it.country, null)
            searchbox.addSearchable(option)
        }
        searchbox.updateSearchResults()
    }

    private fun setupPagerAdapter() {
        val homePagerAdapter = HomePagerAdapter(fragmentManager)
        pager.adapter = homePagerAdapter
        indicator.setViewPager(pager)
    }

    private fun setupSearchBar() {
        searchbox.enableVoiceRecognition(this)
        this.setSupportActionBar(toolbar)
        toolbar.setOnMenuItemClickListener {
            openSearch()
            true
        }
    }

    private fun openSearch() {
        searchbox.revealFromMenuItem(R.id.add, this)

        searchbox.setSearchListener(object : SearchBox.SearchListener {

            override fun onSearchOpened() {
                // Use this to tint the screen

            }

            override fun onSearchClosed() {
                // Use this to un-tint the screen
                searchbox.hideCircularly(this@HomeActivity)
            }

            override fun onSearchTermChanged(term: String) {
                // React to the search term changing
                // Called after it has updated results
            }

            override fun onSearch(searchTerm: String) {
                homePresenter.findCities("London")
            }

            override fun onResultClick(result: SearchResult) {
                //React to result being clicked
            }

            override fun onSearchCleared() {

            }

        })

    }

}
