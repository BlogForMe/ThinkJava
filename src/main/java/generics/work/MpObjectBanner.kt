package com.tngd.uikitsdk.view.bar.generics.work

import generics.extendsuper.Fruit

object MpObjectBanner {
    var callBack: MPBannerHelperCallBack? = null

    fun refrash(callBack: MPBannerHelperCallBack) {
        val arrayList = ArrayList<Fruit>()
        callBack.refreshMPBannerView(arrayList)
    }
}

interface MPBannerHelperCallBack {
    fun funFirst()
    fun refreshMPBannerView(launchableItem: List<Fruit>)
}