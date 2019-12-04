package com.commonpepper.photosen.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import com.commonpepper.photosen.R.*
import com.commonpepper.photosen.ui.fragments.IntroSupportFragment
import com.github.paolorotolo.appintro.AppIntro
import com.github.paolorotolo.appintro.AppIntroFragment
import com.github.paolorotolo.appintro.model.SliderPage

class IntroActivity : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setGoBackLock(true)
        setDepthAnimation()
        val outValue = TypedValue()
        theme.resolveAttribute(attr.selectableItemBackground, outValue, true)
        skipButton.setBackgroundResource(outValue.resourceId)
        doneButton.setBackgroundResource(outValue.resourceId)
        val page1 = SliderPage()
        page1.title = getString(string.welcome)
        page1.description = getString(string.welcome_desc)
        page1.imageDrawable = drawable.big_ic_launcher
        page1.bgColor = color.colorAccent
        addSlide(AppIntroFragment.newInstance(page1))
        val page2 = SliderPage()
        page2.title = getString(string.intro_navigation)
        page2.description = getString(string.intro_navigation_desc)
        page2.imageDrawable = drawable.menu_screen
        page2.bgColor = color.colorAccent
        addSlide(AppIntroFragment.newInstance(page2))
        val page3 = SliderPage()
        page3.title = getString(string.intro_categories)
        page3.description = getString(string.intro_categories_desc)
        page3.imageDrawable = drawable.categories_screen
        page3.bgColor = color.colorAccent
        addSlide(AppIntroFragment.newInstance(page3))
        val page4 = SliderPage()
        page4.title = getString(string.intro_search)
        page4.description = getString(string.intro_search_desc)
        page4.imageDrawable = drawable.search_screen
        page4.bgColor = color.colorAccent
        addSlide(AppIntroFragment.newInstance(page4))
        addSlide(IntroSupportFragment())
    }

    private fun close() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(SCROLL_TO_TOP, true)
        startActivity(intent)
        finish()
    }

    override fun onSkipPressed(currentFragment: Fragment) {
        super.onSkipPressed(currentFragment)
        close()
    }

    override fun onDonePressed(currentFragment: Fragment) {
        super.onDonePressed(currentFragment)
        close()
    }

    companion object {
        const val SCROLL_TO_TOP = "SCROLL_TO_TOP"
    }
}
