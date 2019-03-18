package com.jehutyno.testhappn.di.component

import com.jehutyno.testhappn.di.module.DetailsScreenModule
import com.jehutyno.testhappn.di.scope.DetailsScreenScope
import com.jehutyno.testhappn.ui.details.DetailsFragment
import dagger.Subcomponent

@Subcomponent(modules = [DetailsScreenModule::class])
@DetailsScreenScope
interface DetailsScreenComponent {
    fun inject(fragment: DetailsFragment)
}