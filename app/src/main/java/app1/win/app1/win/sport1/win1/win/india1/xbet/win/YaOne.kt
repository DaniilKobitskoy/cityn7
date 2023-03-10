package app1.win.app1.win.sport1.win1.win.india1.xbet.win

import android.app.Application
import com.onesignal.OneSignal
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig


class YaOne : Application() {
    override fun onCreate() {
        super.onCreate()
        try {
            val config =
                YandexMetricaConfig.newConfigBuilder(myStats.APPMETRICA_KEY).build()
            YandexMetrica.activate(applicationContext, config)
            YandexMetrica.enableActivityAutoTracking(this)

            OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
            OneSignal.initWithContext(this)
            OneSignal.setAppId(myStats.ONESIGNAL_KEY)
        } catch (e: Exception) {
        }
    }
}