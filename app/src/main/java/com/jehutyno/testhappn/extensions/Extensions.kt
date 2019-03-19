package com.jehutyno.testhappn.extensions

import android.app.Activity
import androidx.fragment.app.Fragment
import com.jehutyno.testhappn.BuildConfig.FLAVOR
import com.jehutyno.testhappn.TestHappnApp
import com.jehutyno.testhappn.ui.MainActivity

val Activity.app: TestHappnApp
    get() = application as TestHappnApp

val Fragment.mainActivity: MainActivity
    get() = activity as MainActivity

val Fragment.app: TestHappnApp
    get() = mainActivity.app


val favoriteEnabled = FLAVOR == "favoriteFlavor"